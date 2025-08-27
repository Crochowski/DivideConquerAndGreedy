package assignment2;

import java.util.Arrays;

public class MergeSort {

    private static int[] merge(int[] A1, int[] A2)
    {
        // TASK 2.A.a
        int i = 0;       // A1 pointer - moves through A1 from index 0
        int j = 0;       // A2 pointer - moves through A2 from index 0
        int k = 0;       // A3 pointer - moves through A3 from index 0


        int lenA1 = A1.length;      // Store length of A1
        int lenA2 = A2.length;      // Store length of A2

        int[] A3 = new int[lenA1 + lenA2];  // Create array to place sorted elements - size of A1 + A2

        while (k != A3.length) {    // Until A3 is full

            // First check if either array has been totally traversed, if so fill rest of A3 with other array elements

            if (i == A1.length) {   // If A1 has been totally traversed,
                A3[k] = A2[j];      // Place element from A2 in A3
                j++;                // Increment A2's j pointer
            }

            // place element from A1 in A3
            else if (j == A2.length) {      // If A2 has been traversed,
                A3[k] = A1[i];              // Place element from A1 in A3
                i++;                        // Increment A1's i pointer
            }

            // Otherwise, compare elements at each pointer to one another and place the smaller one in A3


            else if (A1[i] <= A2[j]) {      // If element in A1 less than or equal to the one in A2
                A3[k] = A1[i];              // Place element from A1 in A3
                i++;                        // Increment A1's i pointer
            }

            else {                          // Else if element in A1 greater than the one in A2
                A3[k] = A2[j];              // Place element from A2 in A3
                j++;                        // Increment A2's j pointer
            }

            k++;                            // Increment k pointer every time while loop is run
        }

        return A3;                          // return the merged array

    }

    public static int[] mergesort(int[] A)
    {
        // TASK 2.A.b
        int lenA = A.length;         // Store length of A
        int mid = lenA  / 2;         // Get middle index

        if (lenA < 2) {             // Base case: If A is empty or has only 1 element, it is already sorted
            return A;               // Return the sorted A
        }

        // Split A into two smaller arrays
        int [] B = Arrays.copyOfRange(A,0, mid);        // Array from first element to element before mid
        int [] C = Arrays.copyOfRange(A, mid, lenA);         // Array from middle element to end

        return  merge(mergesort(B), mergesort(C));           // mergesort B and C, merge those results, and return

    }

    private static void print(int[] A)
    {
        for (int i=0; i<A.length; i++) {

            System.out.print(A[i] + ((i<A.length-1)?", ":""));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print(merge(new int[] {1,3,5,7,9}, new int[] {2,4,6,8}));
        print(mergesort(new int[] {5,2,8,1,3,9,7,4,6} ));
    }

}
