import javax.swing.*;

/**
 * Runs the black jack server.
 */
public class RunBlackJackServer {
    /**
     * The entry point of application.
     * @param args the input arguments
     */
    public static void main(String[] args) {
        BlackJackServer server = new BlackJackServer();
        server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        server.execute();
    }
}
