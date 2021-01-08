import java.util.UUID;

/**
 * PostEncryptedPaymentRequest - extends the base class of PostPaymentRequest, which is a base class of PostRequest, Gets a random Form.
 */
public class PostEncryptedPaymentRequest extends PostPaymentRequest{
    /**
     * The Rand encryption scheme.
     */
    private String randEncryptionScheme;
    /**
     * The constant count.
     */
    private static int count = 0;

    /**
     * Instantiates a new Post encrypted payment request.
     * @param randUUID a Universally Unique Identifier of a PostEncryptedPaymentRequest object.
     * @param randIP a random IP address of a PostEncryptedPaymentRequest object.
     * @param randPayment a random Form of a PostEncryptedPaymentRequest object.
     * @param randEncryptionScheme a random encryption scheme for a Payment.
     */
    public PostEncryptedPaymentRequest(UUID randUUID, String randIP, Payment randPayment, String randEncryptionScheme){
        super(randUUID, randIP, randPayment);
        this.randEncryptionScheme = randEncryptionScheme;
        count++;
    }

    /**
     * ToString output.
     * @return output String using overridden toString from base class + encryption scheme of Payment.
     */
    @Override
    public String toString() {
        return (super.toString() + "\nThis payment was encrypted using: " + randEncryptionScheme);
    }

    /**
     * Count amount of requests.
     * @return the number of times a request has been executed.
     */
    public static int count(){
        return count;
    }
}
