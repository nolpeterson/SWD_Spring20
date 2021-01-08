/**
 * CashRegister - Stores all information about bills/coins and performs all math calculations.
 */
public class CashRegister {
    /**
     * The number of Twenties.
     */
    private static int numTwenties;
    /**
     * The number of Tens.
     */
    private static int numTens;
    /**
     * The number of Fives.
     */
    private static int numFives;
    /**
     * The number of Ones.
     */
    private static int numOnes;
    /**
     * The number of Quarters.
     */
    private static int numQuarters;
    /**
     * The number of Dimes.
     */
    private static int numDimes;
    /**
     * The number of Nickels.
     */
    private static int numNickels;
    /**
     * The number of Pennies.
     */
    private static int numPennies;
    /**
     * The amount of change to give.
     */
    private static int change;

    /**
     * setChange - finds the difference between the pricePaid and itemPrice in cents.
     * @param pricePaid the price of the transaction.
     * @param itemPrice the price the customer paid in bills/coins.
     */
    public static void setChange(double pricePaid, double itemPrice) {
        change = (int)Math.round((pricePaid-itemPrice)*100);
    }

    /**
     * getChange - returns the amount of change in cents.
     * @return the amount of change to be given in cents.
     */
    public static int getChange() {
        return change;
    }

    /**
     * setBillsAndCoins - Performs the greedy algorithm to compute the number of each bill and coin to be given.
     */
    public static void setBillsAndCoins() {
        numTwenties = change / 2000;
        if (numTwenties > 0) {
            change = change % 2000;
        }
        numTens = change / 1000;
        if (numTens > 0) {
            change = change % 1000;
        }
        numFives = change / 500;
        if (numFives > 0) {
            change = change % 500;
        }
        numOnes = change / 100;
        if (numOnes > 0) {
            change = change % 100;
        }
        numQuarters = change / 25;
        if (numQuarters > 0) {
            change = change % 25;
        }
        numDimes = change / 10;
        if (numDimes > 0) {
            change = change % 10;
        }
        numNickels = change / 5;
        if (numNickels > 0) {
            change = change % 5;
        }
        numPennies = change;
    }

    /**
     * Gets num twenties.
     * @return the number of twenties to be given to customer.
     */
    public static int getNumTwenties() {
        return numTwenties;
    }

    /**
     * Gets num tens.
     * @return the number of tens to be given to customer.
     */
    public static int getNumTens() {
        return numTens;
    }

    /**
     * Gets num fives.
     * @return the number of fives to be given to customer.
     */
    public static int getNumFives() {
        return numFives;
    }

    /**
     * Gets num ones.
     * @return the number of ones to be given to customer.
     */
    public static int getNumOnes() {
        return numOnes;
    }

    /**
     * Gets num quarters.
     * @return the number of quarters to be given to customer.
     */
    public static int getNumQuarters() {
        return numQuarters;
    }

    /**
     * Gets num dimes.
     * @return the number of dimes to be given to customer.
     */
    public static int getNumDimes() {
        return numDimes;
    }

    /**
     * Gets num nickels.
     * @return the number of nickels to be given to customer.
     */
    public static int getNumNickels() {
        return numNickels;
    }

    /**
     * Gets num pennies.
     * @return the number of pennies to be given to customer.
     */
    public static int getNumPennies() {
        return numPennies;
    }
}
