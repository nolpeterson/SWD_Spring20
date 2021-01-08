import java.util.UUID;

/**
 * PostRequest - extends the base class of Request, Gets the IP address of a Request.
 */
public class PostRequest extends Request {
    /**
     * The Rand ip.
     */
    private String randIP;
    /**
     * The constant count.
     */
    private static int count = 0;

    /**
     * Instantiates a new Post request.
     * @param randUUID a Universally Unique Identifier of a PostRequest object.
     * @param randIP   a random IP address of a PostRequest object.
     */
    public PostRequest(UUID randUUID, String randIP){
        super(randUUID);
        this.randIP = randIP;
        count++;
    }

    /**
     * ToString output.
     * @return output String using overridden toString to display information about the Request.
     */
    @Override
    public String toString() {
        return (super.toString() + "\nPost request to server with IP address: " + randIP);
    }

    /**
     * Count amount of requests.
     * @return the number of times a request has been executed.
     */
    public static int count(){
        return count;
    }
}
