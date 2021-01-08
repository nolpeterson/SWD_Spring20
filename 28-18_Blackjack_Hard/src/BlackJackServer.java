import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The Black jack server.
 */
public class BlackJackServer extends JFrame {
    /**
     * The constant PLAYER_1 identifier.
     */
    private final static int PLAYER_1 = 0;
    /**
     * The constant PLAYER_2 identifier.
     */
    private final static int PLAYER_2 = 1;
    /**
     * Array of player ID's.
     */
    private final static String[] PLAYERID = {"1", "2"};
    /**
     * The Output area.
     */
    private final JTextArea outputArea;
    /**
     * Array of Players.
     */
    private final Player[] players;
    /**
     * The Server socket to connect clients.
     */
    private ServerSocket server;
    /**
     * The Current player.
     */
    private final int currentPlayer;
    /**
     * Runs the players.
     */
    private final ExecutorService runGame;
    /**
     * Locks game for synchronization.
     */
    private final Lock gameLock;
    /**
     * Wait for other player.
     */
    private final Condition otherPlayerConnected;
    /**
     * Wait for other player's turn.
     */
    private final Condition otherPlayerTurn;
    /**
     * The shared deck of cards.
     */
    private final Deck myDeck = new Deck();
    /**
     * The current card that is being played.
     */
    private Card myCard;
    /**
     * The Dealer score.
     */
    private int dealerScore = 0;
    /**
     * Determines if game is over.
     */
    private boolean gameOver = false;

    /**
     * Instantiates a new Black jack server.
     */
    public BlackJackServer() {
        //set title of window
        super("Blackjack Server");
        //create ExecutorService with a thread for each player
        runGame = Executors.newFixedThreadPool(2);
        //create lock for game
        gameLock = new ReentrantLock();
        //condition variable for both players being connected
        otherPlayerConnected = gameLock.newCondition();
        //condition variable for the other player's turn
        otherPlayerTurn = gameLock.newCondition();
        //create array of players
        players = new Player[2];
        //set current player to first player
        currentPlayer = PLAYER_1;

        //set up ServerSocket - port range: 23503 - 23508
        try {
            server = new ServerSocket(23503, 2);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
            System.exit(1);
        }

        //create JTextArea for output
        outputArea = new JTextArea();
        add(outputArea, BorderLayout.CENTER);
        outputArea.setText("Server awaiting connections\n");
        setSize(300, 300);
        setVisible(true);
    }

    /**
     * Execute gets both players connected.
     */
    public void execute() {
        //wait for each client to connect
        for (int i = 0; i < players.length; i++) {
            //wait for connection, create Player, start runnable
            try {
                players[i] = new Player(server.accept(), i);
                //execute player runnable
                runGame.execute(players[i]);
            }
            //execute player runnable
            catch (IOException ioException) {
                ioException.printStackTrace();
                System.exit(1);
            }
        }

        //deal the first card for the dealer
        dealerScore = 0;
        myCard = myDeck.hit();
        dealerScore += myCard.getValue();

        //lock game to signal player x's thread
        gameLock.lock();

        try {
            //resume player 1
            players[PLAYER_1].setSuspended(false);
            //wake up player 1's thread
            otherPlayerConnected.signal();
            //shuffle the deck of cards
            myDeck.shuffle();
        }
        finally {
            //unlock game after signalling player 1
            gameLock.unlock();
        }
    }

    /**
     * Displays message in displayArea.
     * @param messageToDisplay the message to display
     */
    private void displayMessage(final String messageToDisplay) {
        //display message from event-dispatch thread of execution
        SwingUtilities.invokeLater(
                new Runnable() {
                    //updates outputArea
                    public void run()
                    {
                        //add message
                        outputArea.append(messageToDisplay);
                    }
                }
        );
    }

    /**
     * Private inner class Player manages each Player as a runnable thread.
     */
    private class Player implements Runnable {
        /**
         * The Connection to client.
         */
        private final Socket connection;
        /**
         * The Input from client.
         */
        private Scanner input;
        /**
         * The Output to client.
         */
        private Formatter output;
        /**
         * The Mark for each player.
         */
        private final String mark;
        /**
         * The Player number for each thread.
         */
        private final int playerNumber;
        /**
         * Checks whether thread is suspended.
         */
        private boolean suspended = true;

        /**
         * Instantiates a new Player thread.
         * @param socket the socket
         * @param number the thread number, which is also the player number
         */
        public Player(Socket socket, int number) {
            playerNumber = number; //store this player's number
            mark = PLAYERID[playerNumber]; //specify player's mark
            connection = socket; //store socket for client

            //obtain streams from Socket
            try {
                input = new Scanner(connection.getInputStream());
                output = new Formatter(connection.getOutputStream());
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
                System.exit(1);
            }
        }

        /**
         * Control thread's execution.
         */
        public void run() {
            //send client its mark (1 or 0), process messages from client
            try {
                displayMessage("Player " + mark + " connected\n");
                //send player's mark
                output.format("%s\n", mark);
                output.flush();

                //if player 1, wait for another player to arrive
                if (playerNumber == PLAYER_1) {
                    output.format("%s\n%s", "output: Player 1 connected", "output: Waiting for another player\n");
                    output.flush();

                    //wait for player 2
                    gameLock.lock();
                    try {
                        while (suspended) {
                            otherPlayerConnected.await();
                        }
                    }
                    catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                    //unlock game after second player
                    finally {
                        gameLock.unlock();
                    }

                    //send message that other player connected
                    output.format("output: Player 2 connected.\n");
                    output.flush();

                    //output the dealer's first card to player 1
                    output.format("output: Dealer got a " + myCard.toString() + "\n");
                    output.flush();
                }
                else {
                    output.format("output: Player 2 connected.\n");
                    output.flush();

                    //output the dealer's first card to player 2
                    output.format("output: Dealer got a " + myCard.toString() + "\n");
                    output.flush();
                }

                //set client score to zero
                int clientScore = 0;
                //temp string to get input from client
                String inputString;

                // while game not over
                while (!gameOver) {
                    inputString = input.nextLine();

                    //dealHand, this makes a new deck and deals 2 cards to each player + 1 card to dealer
                    if (inputString.equals("dealHand")) {
                        clientScore = 0;

                        //use output: for first run to avoid "Would you like to hit or stand?"
                        myCard = myDeck.hit();
                        clientScore += myCard.getValue();
                        output.format("output: You got a " + myCard.toString() + "\n");
                        output.flush();

                        myCard = myDeck.hit();
                        clientScore += myCard.getValue();
                        output.format("hit: " + myCard.toString() + "\n" + "output: Your score " + clientScore + "\n");
                        output.flush();

                        myCard = myDeck.hit();
                        dealerScore += myCard.getValue();
                    }

                    if (inputString.equals("hit")) {
                        if (clientScore < 21) {
                            myCard = myDeck.hit();
                            clientScore += myCard.getValue();
                            //output the card you were hit with and player score
                            output.format("hit: " + myCard.toString() + "\n" + "output: Your score " + clientScore + "\n");
                            output.flush();
                        }
                        if (clientScore > 21) {
                            output.format("end: You busted! Dealer wins!\n");
                            output.flush();
                        }
                    }

                    else if (inputString.equals("stand")) {
                        //deal a new card to the dealer until their soft cap of 17
                        while (dealerScore < 17) {
                            myCard = myDeck.hit();
                            dealerScore += myCard.getValue();
                        }

                        //find who won
                        //if tie game, the house always wins
                        if (clientScore == dealerScore) {
                            output.format("end: Dealer Wins!: Tie Game " + dealerScore + " to " + clientScore + "\n");
                            output.flush();
                            gameOver = true;
                        }
                        //if the player gets a blackjack, they automatically win
                        else if ((clientScore == 21) && (dealerScore != 21)) {
                            output.format("end: You Win, You got a Blackjack! " + clientScore + " to " + dealerScore + "\n");
                            output.flush();
                            gameOver = true;
                        }
                        //if the dealer has a score higher than client and less than 21, they win
                        else if ((dealerScore > clientScore) && (dealerScore <= 21)) {
                            output.format("end: Dealer Wins: " + dealerScore + " to " + clientScore + "\n");
                            output.flush();
                            gameOver = true;
                        }
                        //if the dealer goes over 21 they bust, and client wins
                        else if (dealerScore > 21) {
                            output.format("end: You Win: Dealer busted " + clientScore + " to " + dealerScore + "\n");
                            output.flush();
                            gameOver = true;
                        }
                        //any other case, the client wins
                        else {
                            output.format("end: You Win: " + clientScore + " to " + dealerScore + "\n");
                            output.flush();
                            gameOver = true;
                        }
                    }
                }
            }

            //close connection to client
            finally {
                try {
                    connection.close();
                }
                catch (IOException ioException) {
                    ioException.printStackTrace();
                    System.exit(1);
                }
            }
        }

        /**
         * Sets whether or not thread is suspended
         * @param status the status of suspension
         */
        public void setSuspended(boolean status) {
            //set value of suspended
            suspended = status;
        }
    }
}
