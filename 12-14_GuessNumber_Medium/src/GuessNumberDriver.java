import javax.swing.*;

/**
 * Driver program that allows you to run program and set attributes.
 */
public class GuessNumberDriver extends JFrame{
    /**
     * The entry point of application.
     * @param args the input arguments.
     */
    public static void main(String[] args) {
        GuessNumber guesser = new GuessNumber();
        guesser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guesser.setSize(300, 300);
        guesser.setResizable(false);
        guesser.setVisible(true);
    }
}
