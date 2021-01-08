import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Class that contains the program.
 */
public class GuessNumber extends JFrame {
    /**
     * JTextField allowing you to put in guess.
     */
    JTextField input = new JTextField();
    /**
     * Listener to detect changes to JTextField.
     */
    TextFieldListener textFieldListener = new TextFieldListener();
    /**
     * Listener to detect changes to JButton.
     */
    ButtonListener buttonListener = new ButtonListener();
    /**
     * Random number generator.
     */
    Random rand = new Random();
    /**
     * The random number to be guessed.
     */
    int guess;
    /**
     * Distance the current user guess is from random number.
     */
    int distance;
    /**
     * The previous distance the guess was from random number.
     */
    int prevDistance;
    /**
     * The previous guess.
     */
    int prevGuess;
    /**
     * Label to describe game rules.
     */
    JLabel guessLabel;
    /**
     * Label to say "Too Hot" or "Too Cold".
     */
    JLabel warmth;
    /**
     * The new game button.
     */
    JButton newGame;

    /**
     * Instantiates a new Guess number.
     */
    public GuessNumber() {
        super("Guess Number");
        setLayout(new GridLayout(4,1));
        getContentPane().setBackground(Color.WHITE);

        guessLabel = new JLabel("<html>I have a number between 1 and 1000." +
                "<br>Can you guess my number?<br><br>Please Enter your guess.</html>");
        newGame = new JButton("New game");
        newGame.addActionListener(buttonListener);
        input.addActionListener(textFieldListener);
        warmth = new JLabel("");
        guess = rand.nextInt(1000);
        distance = 1000;
        prevDistance = 1000;
        prevGuess = 0;

        add(guessLabel);
        add(input);
        add(warmth);
    }

    /**
     * TextFieldListener detects any changes made to the JTextField.
     */
    private class TextFieldListener implements ActionListener {
        /**
         * Detects if a event happens to the JTextField and then will compute if the guess is too low, too high,
         * or correct. Furthermore, the "warmth" color will be computed and displayed.
         * @param event - detects if an event happens in the program.
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            int myGuess = Integer.parseInt(input.getText());
            distance = guess - myGuess;

            if (myGuess < guess) {
                warmth.setText("Too Low");
            }
            else if (myGuess > guess) {
                warmth.setText("Too High");
            }
            else {
                warmth.setText("Correct!");
                input.setEditable(false);
                add(newGame);
            }

            if (prevDistance > distance) {
                getContentPane().setBackground(Color.RED);
            }
            else if((prevDistance < distance)) {
                getContentPane().setBackground(Color.BLUE);
            }

            prevDistance = guess - myGuess;
            prevGuess = myGuess;
        }
    }

    /**
     * ButtonListener detects any changes made to the JButton.
     */
    private class ButtonListener implements ActionListener {
        /**
         * Detects if a event happens to the JButton and then will reset the game to guess for a new random number.
         * @param event - detects if an event happens in the program.
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            guess = rand.nextInt(1000);
            distance = 1000;
            prevDistance = 1000;
            prevGuess = 0;
            getContentPane().setBackground(Color.WHITE);
            remove(newGame);
            warmth.setText("");
            input.setEditable(true);
        }
    }
}
