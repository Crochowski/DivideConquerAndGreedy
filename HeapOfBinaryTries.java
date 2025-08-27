package assignment2;

public class HeapOfBinaryTries {
    private BinaryTrie[] A;
    private int heapsize;

    private void heapify(int i)  {
        // TASK 3.A.a
        while (true) {              // Run the loop as long as the heap property is not satisfied
            int l = i * 2 + 1;      // Index of left descendant
            int r = i * 2 + 2;      // Index of right descendant

            int smallest = i;       // Begin by assuming that the value in i is the smallest value

            if (l < heapsize && A[l].compare(A[i])) {   // If left descendant exists and is smaller than i
                smallest = l;                           // left descendant is now smallest
            }

            if (r < heapsize && A[r].compare(A[smallest])) {    // If right descendant exists and is yet smaller again
                smallest = r;                                   // Right descendant is now smallest
            }

            if (smallest != i) {                // If the smallest node has changed
                BinaryTrie temp = A[smallest];  // Swap it with i, i.e. smallest node moves up a level
                A[smallest] = A[i];
                A[i] = temp;

                i = smallest; // Move i down a level & loop again
            }

            else { // If the smallest node has not changed, heap property is satisfied, so stop
                break;
            }

        }


    }

    public HeapOfBinaryTries(BinaryTrie[] A)
    {
        // TASK 3.A.b
        this.A = A;                     // Array on which heap will be implemented
        this.heapsize = A.length;       // The capacity of the heap
    }

    public BinaryTrie extractMin()
    {
        // TASK 3.A.c
        BinaryTrie min = A[0];      // The minimum element is the first one in the heap
        A[0] = A[heapsize - 1];     // Replace first element with last
        heapsize --;                // Reduce heapsize by 1 to account for removed element
        heapify(0);               // Start from the top of the heap reorder if necessary to resatisfy heap property

        return min;                 // return the minimum element


    }

    public void insert(BinaryTrie x) {
        // TASK 3.A.d
        heapsize ++;            // Increase heapsize so that there is space to insert new element

        int i = heapsize - 1;   // Store last index

        while (i > 0 && x.compare(A[(i - 1) / 2])) {    // Until top node is reached or x < value of i's parent
            int parent = (i - 1) / 2;                   // Store parent index
            A[i] = A[parent];           // Move the parent down a level
            i = parent;                 // Now move i pointer up to the node where the parent was
        }

        A[i] = x;                       // Insert the element
    }

    public int size()
    {
        return heapsize;
    }
}
