import java.util.Scanner;

/**
 * EncryptString - Takes in a string, then performs a random shift to each letter and returns the encrypted string, and cipher key.
 */
public class EncryptString {
    /**
     * Char array of all the letters of the alphabet
     */
    final static char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    /**
     * Convert char to index.
     * @param convert the character to be converted.
     * @return the index of the converted character.
     */
    public static int convertToIndex(char convert){
        int index = 0;
        for(int i = 0; i< alphabet.length; i++) {
            if (convert == alphabet[i]) {
                index = i;
            }
        }
        return index;
    }

    /**
     * main - runs the encryption program.
     * @param args the input arguments
     */
    public static void main(String[] args) {
        /**
         * @param str input string to be encrypted.
         * @param nVal array to hold the randomized n value shifts for each character of the string to be encrypted.
         * @param shift variable to hold the shifted index after a random N value is added.
         */
        Scanner input = new Scanner(System.in);
        System.out.print("Enter string to encrypt: ");
        String str = input.nextLine();
        //Force the string to uppercase.
        str = str.toUpperCase();
        int[] nVal = new int[str.length()];
        int shift;

        //Output formatting
        System.out.println("\nEncrypted string: ");

        //Loop through all elements of the string and encode them by an N value shift through the alphabet.
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                System.out.print(' ');
            }
            else {
                //Creates a random integer for a shift n
                nVal[i] = (int) (Math.random()*((26-1)+1))+1;
                //add the shift to the index of the current character, and make sure the index !> 26 with % 26.
                shift = convertToIndex(str.charAt(i)) + nVal[i];
                if (shift >= 26) {
                    shift = shift % 26;
                }
                System.out.print(alphabet[shift]);
            }
        }

        //Print the N values on one line that correspond to each index of the encrypted string.
        System.out.println("\n\nCipher Key: ");
        for (int value : nVal) {
            System.out.print(value + " ");
        }
    }
}
