package assignment2;

import java.util.Arrays;

public class QuickSort {

    private static int partition(int[] A, int p, int r)
    {
        // TASK 2.B.a
        int pivot = A[r];       // Pivot will be last element in A

        int i = p-1;     // Smaller elements will be placed within a boundary that is <= i
                         // i will be incremented when j points to a value <= the pivot
                         // that element @ j will then be swapped with the current value at i

        int temp = 0;   // Temp variable to use when swapping i and j

        for (int j = p; j <= r-1; j++) {    // Iterate over entire array except the pivot

            if (A[j] <= pivot) {            // If value of current j pointer <= pivot
                i++;                        // Increment i

                temp = A[i];                // Swap i and j. This ensures that at the end, all values at and before i are <= the pivot
                A[i] = A[j];
                A[j] = temp;
            }
        }

        // Now swap pivot with i+1. i+1 is the first value larger than the pivot, so placing pivot here will put it in
        // the middle.
        temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp;

        return i+1;     // return the pivot, now situated @ i+1
    }

    private static void quicksort(int[] A, int p, int r)
    {
        // TASK 2.B.b
        if (r <= p) {         // Base case - if r < p, subarray has 0 or 1 elements and is sorted already
            return;
        }

        int q = partition(A, p, r);    // Store index of final pivot location from last partition
        quicksort(A, p, q-1);       // Quicksort from p to index before last pivot
        quicksort(A, q+1, r);      // Quicksort from index after last pivot to r


    }

    public static void quicksort(int[] A)
    {
        quicksort(A, 0, A.length-1);
    }

    private static void print(int[] A)
    {
        for (int i=0; i<A.length; i++)
        {
            System.out.print(A[i] + ((i<A.length-1)?", ":""));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = new int[] {5,2,8,1,3,9,7,4,6};
        quicksort(A);
        print(A);
    }

}
