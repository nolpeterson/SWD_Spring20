import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The Black jack client.
 */
public class BlackJackClient extends JFrame implements Runnable {
    /**
     * The Id for first client.
     */
    private final String ID_1 = "1";
    /**
     * The Id for second client.
     */
    private final String ID_2 = "2";
    /**
     * The Display area for output.
     */
    private final JTextArea displayArea;
    /**
     * The Hit button.
     */
    private final JButton hit;
    /**
     * The Hit listener.
     */
    private final hitListener hitListener = new hitListener();
    /**
     * The Stand button.
     */
    private final JButton stand;
    /**
     * The Stand listener.
     */
    private final standListener standListener = new standListener();
    /**
     * The Panel to hold JTextArea and sub panel of buttons.
     */
    private final JPanel panel;
    /**
     * The Sub panel to hold buttons.
     */
    private final JPanel subPanel;
    /**
     * The Connection to server.
     */
    private Socket connection;
    /**
     * The Input from server.
     */
    private Scanner input;
    /**
     * The Output to server.
     */
    private Formatter output;
    /**
     * The host name for server.
     */
    private final String BlackJackHost;
    /**
     * This client's ID.
     */
    private String myID;
    /**
     * Determines which client's turn it is.
     */
    private boolean myTurn;

    /**
     * Instantiates a new Black jack client.
     * @param host the host
     */
//set up user-interface and board
    public BlackJackClient(String host) {
        super("Blackjack");
        BlackJackHost = host;
        panel = new JPanel();
        subPanel = new JPanel();
        displayArea = new JTextArea(14, 30);
        displayArea.setEditable(false);
        //set background color of board to green
        Color color = new Color(31, 170, 42);
        displayArea.setBackground(color);
        //set text color to white
        displayArea.setForeground(Color.WHITE);
        hit = new JButton("Hit");
        hit.addActionListener(hitListener);
        stand = new JButton("Stand");
        stand.addActionListener(standListener);
        panel.setLayout(new BorderLayout());
        subPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(displayArea, BorderLayout.NORTH);
        subPanel.add(hit);
        subPanel.add(stand);
        panel.add(subPanel, BorderLayout.SOUTH);
        add(panel);
        setSize(300, 300);
        setVisible(true);

        startClient();
    }

    /**
     * Start client thread.
     */
    public void startClient() {
        //connect to server and get streams
        try {
            //make connection to server - port range: 23503 - 23508
            connection = new Socket(InetAddress.getByName(BlackJackHost), 23503);

            //get streams for input and output
            input = new Scanner(connection.getInputStream());
            output = new Formatter(connection.getOutputStream());
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }

        //create and start worker thread for this client
        ExecutorService worker = Executors.newFixedThreadPool(1);
        worker.execute(this); // execute client
    }

    /**
     * Control thread that allows continuous update of displayArea.
     */
    public void run() {
        //get player's ID (1 or 2)
        myID = input.nextLine();

        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        //display player's mark
                        displayArea.setText("You are player \"" + myID + "\"");
                    }
                }
        );

        //determine if client's turn
        myTurn = (myID.equals(ID_1));
        System.out.println((myID.equals(ID_1)));

        //call dealHand to deal 2 cards to each player + 1 card to dealer
        output.format("dealHand\n");
        output.flush();

        //receive messages sent to client and output them
        while (true) {
            if (input.hasNextLine())
                processMessage(input.nextLine());
        }
    }

    /**
     * Process messages received by client from server.
     * @param message the message to be processed
     */
    private void processMessage(String message) {
        if (message.contains("hit:"))
        {
            message = message.replace("hit: ", "");
            displayMessage("\nYou got a " + message);
            displayMessage("\nWould you like to Hit or Stand?");
        }
        if (message.contains("output:"))
        {
            message = message.replace("output: ", "");
            displayMessage("\n" + message);
        }
        if (message.contains("end:")) {
            message = message.replace("end: ", "");
            displayMessage("\n" + message);
        }
    }

    /**
     * Display message to client.
     * @param messageToDisplay the message to display
     */
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        displayArea.append(messageToDisplay);
                    }
                }
        );
    }

    /**
     * The Hit listener.
     */
    private class hitListener implements ActionListener {
        /**
         * Outputs a "hit\n" formatted message to server to make a "hit" on player's thread.
         * @param event the event
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            if (myTurn = true) {
                output.format("hit\n");
                output.flush();
            }
        }
    }

    /**
     * The Stand listener.
     */
    private class standListener implements ActionListener {
        /**
         * Outputs a "stand\n" formatted message to server to make a "stand" on player's thread.
         * @param event the event
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            if (myTurn = true) {
                output.format("stand\n");
                output.flush();
                myTurn = false;
            }
        }
    }
}
