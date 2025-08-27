package assignment2;

import java.util.Arrays;

public class DivideAndConquer {

    public static int fibonacci(int n) {
        // TASK 1.A.a
        if (n < 2) {            // Base case: if n=0 or n=1, return that number
            return n;
        }
        else {
            return fibonacci(n - 1) + fibonacci(n - 2); // Otherwise, return the sum of the previous 2 nums in Fibonacci sequence
        }

    }

    public static int search(int[] A, int v, int start, int end) {
        // TASK 1.A.b

        // If v > any number in array, it will keep being searched to the right until start > end
        // If v < any number in array, it will keep being searched to the left until end < start
        if (start > end) {
            return -1;      // Return -1 if the element is not to be found.
        }


        int mid = (start + end) / 2; // (start + end) / 2 gives middle number between the two indexes


        if (A[mid] == v) {      // Base case - If the middle number is equal to v, return the index of the middle number
            return mid;
        }

        else if (A[mid] < v) {
            return search(A, v, mid + 1, end);  // Search right - everything to the right of the middle number
        }

        else {
            return search(A, v, start, mid - 1); // Search left - everything to the left of the middle number
        }

    }


    public static void hanoi(int n, char A, char B, char C) {
        // TASK 1.A.c
        if (n == 1) {   // Base case - If there is only one disc, move it from A --> C
            System.out.print(A);
            System.out.print("-->");
            System.out.println(C);
        }

        else {
            hanoi(n - 1, A, C, B);      // Move top n-1 disks from A to B
            hanoi(1, A, B, C);          // Move bottom disk from A to C
            hanoi(n - 1, B, A, C);      // Move remaining n-1 disks from B to C
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacci(i));
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println(search(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, i,0, 9));
        }
        System.out.println();
        hanoi(4, 'A', 'B', 'C');
    }
}
