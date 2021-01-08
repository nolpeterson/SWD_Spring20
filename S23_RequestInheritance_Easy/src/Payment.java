/**
 * Payment - an Object that has a Name of sender, amount, and name of recipient.
 */
public class Payment {
    /**
     * The Rand name.
     */
    private String randName;
    /**
     * The Rand name 2.
     */
    private String randName2;
    /**
     * The Amount.
     */
    private int amount;

    /**
     * Instantiates a new Payment.
     * @param randName random name of sender.
     * @param amount amount of the payment.
     * @param randName2 random name of the recipient.
     */
    public Payment(String randName, int amount, String randName2){
        this.randName = randName;
        this.randName2 = randName2;
        this.amount = amount;
    }

    /**
     * ToString output.
     * @return output String using overridden toString to display information about the Payment object.
     */
    @Override
    public String toString(){
        return "\n-Payment Info-\nTo: " + getRandName() + "\nAmount: " + getAmount() + "\nFrom: " + getRandName2();
    }

    /**
     * Gets rand name.
     * @return the random name of the sender.
     */
    public String getRandName() {
        return randName;
    }

    /**
     * Gets rand name 2.
     * @return the amount of the payment.
     */
    public String getRandName2() {
        return randName2;
    }

    /**
     * Gets amount.
     * @return the random name of the recipient.
     */
    public int getAmount() {
        return amount;
    }
}
