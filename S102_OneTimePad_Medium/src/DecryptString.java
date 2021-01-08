import java.util.Scanner;

/**
 * DecryptString - Takes in an encrypted string and cipher key, then decrypts the string to original string.
 */
public class DecryptString {
    /**
     * Char array of all the letters of the alphabet.
     */
    final static char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    /**
     * Convert index to char.
     * @param convert the index of the character to be converted.
     * @return the original character of convert.
     */
    public static char convertToLetter(int convert){
        return alphabet[convert];
    }

    /**
     * main - runs the decryption program.
     * @param args the input arguments
     */
    public static void main(String[] args) {
        /**
         * @param str input string to be decrypted.
         * @param cipher input string of cipher key.
         * @param nVal array to hold the cipher key values for each character of the string to be decrypted.
         * @param shift variable to hold the shifted index after a random N value is added.
         */
        Scanner input = new Scanner(System.in);
        System.out.print("Enter string to decrypt: ");
        String str = input.nextLine();
        //Force the string to uppercase.
        str = str.toUpperCase();
        //Take in the cipher key to decrypt string.
        System.out.print("Enter the cipher key: ");
        String cipher = input.nextLine();
        String[] nVal = cipher.split("\\s+");
        int shift;

        //Output formatting
        System.out.println("\nDecrypted string: ");

        //Loop through all elements of the string and decode them by an N value shift through the alphabet.
        for (int i = 0; i < str.length(); i++) {
            //Print a space if a space is found in string.
            if (str.charAt(i) == ' ') {
                System.out.print(' ');
            }
            else {
                //Loops through th alphabet and finds the corresponding letter of the string. Then takes the index of
                //the letter and shifts it backwards by the nVal, making sure to not go out of bounds.
                for (int j = 0; j < alphabet.length; j++) {
                    if (str.charAt(i) == alphabet[j]) {
                        shift = (j - Integer.parseInt(nVal[i]));
                        if (shift < 0) {
                            shift = shift + 26;
                        }
                        //Print the decrypted letter.
                        System.out.print(convertToLetter((shift)));
                    }
                }
            }
        }
    }
}
