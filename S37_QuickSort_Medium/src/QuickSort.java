/**
 * The quick sort algorithm.
 */
public class QuickSort {

    /**
     * Sort method that performs the quick sort.
     * @param myArray the array to be sorted
     * @param pivot1 the first pivot point
     * @param pivot2 the second pivot point
     */
    public static void sort(int[] myArray, int pivot1, int pivot2) {
        //Base case return to break recursion
        if (pivot2 <= pivot1) {
            return;
        }

        //Swap the pivots if the second pivot is less than the first pivot
        if (myArray[pivot2] < myArray[pivot1]) {
            swap(myArray, pivot1, pivot2);
        }

        //Variables for making comparisons in each partition
        int pivotRef1 = pivot1 + 1;
        int pivotRef2 = pivot2 - 1;
        int comparison = pivotRef1;

        //Sort partition from (pivot1 + 1) to (pivot2 - 1) = 3 total partitions
        while (comparison <= pivotRef2) {
            if (myArray[comparison] < myArray[pivot1]) {
                swap(myArray, pivotRef1++, comparison++);
            }
            else if (myArray[pivot2] < myArray[comparison]) {
                swap(myArray, comparison, pivotRef2--);
            }
            else {
                comparison++;
            }
        }

        //Perform swaps for next partition in recursion
        swap(myArray, pivot1, --pivotRef1);
        swap(myArray, pivot2, ++pivotRef2);
        sort(myArray, pivot1, pivotRef1 - 1);

        //Put partitions in order
        if (myArray[pivotRef1] < myArray[pivotRef2]) {
            sort(myArray,pivotRef1 + 1,pivotRef2 - 1);
        }

        //Call next recursion
        sort(myArray, pivotRef2 + 1, pivot2);
    }

    /**
     * Swaps two elements.
     * @param myArray the array to be sorted
     * @param pivot1 the first pivot point
     * @param pivot2 the second pivot point
     */
    public static void swap(int[] myArray, int pivot1, int pivot2){
        int temp = myArray[pivot1];
        myArray[pivot1] = myArray[pivot2];
        myArray[pivot2] = temp;
    }

    /**
     * Prints out all elements of the array
     * @param myArray the array to be printed
     */
    public static void displayArray(int[] myArray) {
        //Print opening brace
        System.out.print("[");
        for (int i = 0; i < 100; i++) {
            //Create a new line every 10 numbers for formatting
            if (i % 10 == 0 && i != 0) {
                System.out.println();
            }
            //Print element
            System.out.print(myArray[i]);
            //Print a comma and space for every element except the last
            if (i != 99) {
                System.out.print(", ");
            }
        }
        //Print closing brace
        System.out.println("]");
    }
}
