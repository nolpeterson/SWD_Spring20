import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * ChangeComputation - Driver program that handles all input and output.
 */
public class ChangeComputation {
    /**
     * The entry point of application.
     * @param args the input arguments
     */
    public static void main(String[] args) {
        //Scanner object called input
        Scanner input = new Scanner(System.in);
        double itemPrice, pricePaid;

        //Ask user for the price of the item.
        System.out.print("Enter the cost of the transaction: $");
        itemPrice = input.nextDouble();

        //Check to make sure the transaction cost is valid
        while (itemPrice < 0.01) {
            System.out.print("Invalid amount entered.\nEnter the cost of the transaction: $");
            itemPrice = input.nextDouble();
        }

        //Get the amount of each bill/coin the customer paid with.
        pricePaid = getBillsAndCoins();

        //Check to make sure the amount paid is a valid amount.
        while (pricePaid < itemPrice) {
            System.out.print("\nInvalid amount entered.");
            pricePaid = getBillsAndCoins();
        }

        //Set the amount of change required for the transaction.
        CashRegister.setChange(pricePaid, itemPrice);

        //Output the amount of change that is due using implicit double division, which converts integer cents back
        //into $(dollars).(cents) using DecimalFormat.
        DecimalFormat dec = new DecimalFormat("$0.00");
        System.out.println("\nChange due: " + dec.format(CashRegister.getChange()/100.0));

        //Generate the number of each required bill/coin.
        CashRegister.setBillsAndCoins();

        //Final output to display amount of each bill/coin.
        getOutput();
    }

    /**
     * getBillsAndCoins - gets the user input of each bill/coin
     * @return the amount the customer paid.
     */
    public static double getBillsAndCoins() {
        Scanner input = new Scanner(System.in);
        double pricePaid;
        int  cTwenties, cTens, cFives, cOnes, cQuarters, cDimes, cNickels, cPennies;

        System.out.println("\nEnter the amount of each bill/coin the customer paid with:");
        System.out.print("Twentie(s): ");
        cTwenties = input.nextInt();
        pricePaid = cTwenties * 20.00;
        System.out.print("Ten(s): ");
        cTens = input.nextInt();
        pricePaid += cTens * 10.00;
        System.out.print("Five(s): ");
        cFives = input.nextInt();
        pricePaid += cFives * 5.00;
        System.out.print("One(s): ");
        cOnes = input.nextInt();
        pricePaid += cOnes * 1.00;
        System.out.print("Quarter(s): ");
        cQuarters = input.nextInt();
        pricePaid += cQuarters * 0.25;
        System.out.print("Dime(s): ");
        cDimes = input.nextInt();
        pricePaid += cDimes * 0.10;
        System.out.print("Nickel(s): ");
        cNickels = input.nextInt();
        pricePaid += cNickels * 0.05;
        System.out.print("Pennie(s): ");
        cPennies = input.nextInt();
        pricePaid += cPennies * 0.01;

        return pricePaid;
    }

    /**
     * getOutput - prints a formatted output of the number of each bill/coin required.
     */
    public static void getOutput() {
        System.out.println("\nNumber of twenties: " + CashRegister.getNumTwenties());
        System.out.println("Number of tens: " + CashRegister.getNumTens());
        System.out.println("Number of fives: " + CashRegister.getNumFives());
        System.out.println("Number of ones: " + CashRegister.getNumOnes());
        System.out.println("Number of quarters: " + CashRegister.getNumQuarters());
        System.out.println("Number of dimes: " + CashRegister.getNumDimes());
        System.out.println("Number of nickels: " + CashRegister.getNumNickels());
        System.out.println("Number of pennies: " + CashRegister.getNumPennies());
    }
}
