import java.util.UUID;

/**
 * GetRequest - extends the base class of Request, Gets the URL of a request.
 */
public class GetRequest extends Request {
    /**
     * The Rand url.
     */
    private String randURL;
    /**
     * The constant count.
     */
    private static int count = 0;

    /**
     * Instantiates a new Get request.
     * @param randUUID a Universally Unique Identifier of a GetRequest object.
     * @param randURL a random Universal Resource Locator of a GetRequest object.
     */
    public GetRequest(UUID randUUID, String randURL){
        super(randUUID);
        this.randURL = randURL;
        count++;
    }

    /**
     * ToString output.
     * @return output String using overridden toString from base class.
     */
    @Override
    public String toString(){
        return (super.toString());
    }

    /**
     * Count amount of requests.
     * @return the number of times a request has been executed.
     */
    public static int count(){
        return count;
    }
}