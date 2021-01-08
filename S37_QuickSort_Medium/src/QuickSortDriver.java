import java.util.Random;

/**
 * Driver program to run the quick sort.
 */
public class QuickSortDriver {
    /**
     * The entry point of application.
     * @param args the input arguments
     */
    public static void main(String[] args) {
        //Generate a random array of 100 elements from 0-100
        Random rand = new Random();
        int[] myArray = new int[100];
        for (int i = 0; i < 100; i++) {
            myArray[i] = rand.nextInt(101);
        }

        //Display the generated array
        System.out.println("Unsorted Array:");
        QuickSort.displayArray(myArray);

        //Display the value of the pivots
        System.out.println("\nRandom pivots: " + myArray[0] + " & " + myArray[99]);

        //Sort the array, and use the first and last indices as the pivot positions
        QuickSort.sort(myArray, 0, 99);

        //Display the sorted array
        System.out.println("\nSorted Array:");
        QuickSort.displayArray(myArray);
    }
}
