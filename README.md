# Series of Algorithms and Data Structures

Java implementations of several classic algorithms and data structures:
- **Greedy:** activity selection, coin change
- **Divide & Conquer:** Fibonacci, binary search, Towers of Hanoi
- **Compression:** Huffman coding (encode/decode with a binary trie + min-heap)
- **Sorting:** Merge Sort, Quick Sort
- **Heap:** A min-heap of binary tries


## Project Structure

### Provided by University Lecturer
- `Activity.java` — simple interval model (id, start, finish) with `overlap()` and `print()`
- `BinaryTrie.java` — nodes for Huffman tree + code table generation (map of chars → bitstrings)

### Implemented by myself
- `Greedy.java` — Activity Selection (interval scheduling) + coin change (greedy)
- `DivideAndConquer.java` — `fibonacci`, recursive `search` (binary search), `hanoi`
- `Huffman.java` — builds Huffman tree, `encode`, `decode`, `printCodeTable`
- `HeapOfBinaryTries.java` — min-heap priority queue of `BinaryTrie` nodes (used by Huffman)
- `MergeSort.java` — merge + mergesort utilities
- `QuickSort.java` — in-place quicksort

## Requirements
- Java 11+
- Any IDE (IntelliJ / Eclipse) 

## How to Run

Open the project and run the `main` methods in any of:
- `Greedy.java`
- `DivideAndConquer.java`
- `Huffman.java`
- `MergeSort.java`
- `QuickSort.java`

## Notes
Notes

- Greedy: prints selected activities (non-overlapping) and coin change breakdown.

- Divide & Conquer: prints Fibonacci sequence, binary search results, and a Hanoi move sequence.

- Huffman: prints the code table, encoded bitstring, and the decoded string.

- MergeSort/QuickSort: prints the sorted arrays

