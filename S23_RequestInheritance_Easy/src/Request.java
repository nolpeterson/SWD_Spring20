import java.util.UUID;

/**
 * Request - base class of hierarchy, and models all base requests for server.
 */
public class Request {
    /**
     * The Rand uuid.
     */
    private UUID randUUID;
    /**
     * The constant count.
     */
    private static int count = 0;

    /**
     * Instantiates a new Request.
     * @param randUUID the Universally Unique Identifier of a request object.
     */
    public Request(UUID randUUID){
        this.randUUID = randUUID;
        count++;
    }

    /**
     * ToString output.
     * @return output String using overridden toString from base class + the randUUID from Request.
     */
    @Override
    public String toString() {
        System.out.println("RequestInheritance." + super.toString());
        return ("UUID: " + randUUID);
    }

    /**
     * Count amount of requests.
     * @return the number of times a request has been executed.
     */
    public static int count(){
        return count;
    }
}
