import java.util.UUID;

/**
 * PostPaymentRequest - extends the base class of PostRequest, which is a base class of Request, Gets a random Payment.
 */
public class PostPaymentRequest extends PostRequest{
    /**
     * The Rand payment.
     */
    private Payment randPayment;
    /**
     * The constant count.
     */
    private static int count = 0;

    /**
     * Instantiates a new Post payment request.
     * @param randUUID    a Universally Unique Identifier of a PostPaymentRequest object.
     * @param randIP      a random IP address of a PostPaymentRequest object.
     * @param randPayment a random Payment of a PostPaymentRequest object.
     */
    public PostPaymentRequest(UUID randUUID, String randIP, Payment randPayment){
        super(randUUID, randIP);
        this.randPayment = randPayment;
        count++;
    }

    /**
     * ToString output.
     * @return output String using overridden toString to display information about the Payment Request.
     */
    @Override
    public String toString() {
        return (super.toString() + randPayment.toString());
    }

    /**
     * Count amount of requests.
     * @return the number of times a request has been executed.
     */
    public static int count(){
        return count;
    }
}
