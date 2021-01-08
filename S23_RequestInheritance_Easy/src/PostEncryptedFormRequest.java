import java.util.UUID;

/**
 * PostEncryptedFormRequest - extends the base class of PostFormRequest, Adds an encryption scheme to PostFormRequest.
 */
public class PostEncryptedFormRequest extends PostFormRequest{
    /**
     * The Rand form encryption scheme.
     */
    private String randFormEncryptionScheme;
    /**
     * The constant count.
     */
    private static int count = 0;

    /**
     * Instantiates a new Post encrypted form request.
     * @param randUUID a Universally Unique Identifier of a PostEncryptedFormRequest object.
     * @param randIP a random IP address of a PostEncryptedFormRequest object.
     * @param randForm a random Form of a PostEncryptedFormRequest object.
     * @param randFormEncryptionScheme a random encryption scheme for a Form.
     */
    public PostEncryptedFormRequest(UUID randUUID, String randIP, Form randForm, String randFormEncryptionScheme){
        super(randUUID, randIP, randForm);
        this.randFormEncryptionScheme = randFormEncryptionScheme;
        count++;
    }

    /**
     * ToString output.
     * @return output String using overridden toString from base class + encryption scheme of Form.
     */
    @Override
    public String toString() {
        return (super.toString() + "\nThis form was encrypted using: " + randFormEncryptionScheme);
    }

    /**
     * Count amount of requests.
     * @return the number of times a request has been executed.
     */
    public static int count(){
        return count;
    }
}
