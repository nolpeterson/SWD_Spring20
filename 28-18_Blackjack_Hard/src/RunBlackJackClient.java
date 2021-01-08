import javax.swing.*;

/**
 * Runs the black jack client.
 */
public class RunBlackJackClient {
    /**
     * The entry point of application.
     * @param args the input arguments
     */
    public static void main(String[] args) {
        BlackJackClient client; // declare client application

        // if no command line args
        if (args.length == 0)
            client = new BlackJackClient("127.0.0.1"); // localhost
        else
            client = new BlackJackClient(args[0]); // use args

        client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
