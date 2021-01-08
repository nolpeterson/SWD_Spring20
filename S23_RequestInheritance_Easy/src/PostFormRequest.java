import java.util.UUID;

/**
 * PostFormRequest - extends the base class of PostRequest, which is a base class of Request, Gets a random Form.
 */
public class PostFormRequest extends PostRequest {
    /**
     * The Rand form.
     */
    private Form randForm;
    /**
     * The constant count.
     */
    private static int count = 0;

    /**
     * Instantiates a new Post form request.
     * @param randUUID a Universally Unique Identifier of a PostFormRequest object.
     * @param randIP   a random IP address of a PostFromRequest object.
     * @param randForm a random Form of a PostFormRequest object.
     */
    public PostFormRequest(UUID randUUID, String randIP, Form randForm){
        super(randUUID, randIP);
        this.randForm = randForm;
        count++;
    }

    /**
     * ToString output.
     * @return output String using overridden toString to display information about the Form Request.
     */
    @Override
    public String toString() {
        return (super.toString() + randForm.toString());
    }

    /**
     * Count amount of requests.
     * @return the number of times a request has been executed.
     */
    public static int count(){
        return count;
    }
}
