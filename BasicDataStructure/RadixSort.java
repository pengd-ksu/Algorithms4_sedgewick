import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class RadixSort {
    private static final int NUM_DIGITS = 10;

    public static void countingSort(int[] arr, int placeVal) {
        // Sorts an array of integers where minimum value is 0 and maximum value is K
        int[] counts = new int[NUM_DIGITS];

        for (int elem : arr) {
            int current = elem / placeVal;
            counts[current % NUM_DIGITS] += 1;
        }

        // we now overwrite our original counts with the starting index
        // of each digit in our group of digits
        int startingIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }

        int[] sortedArray = new int[arr.length];
        for (int elem : arr) {
            int current = elem / placeVal;
            sortedArray[counts[current % NUM_DIGITS]] = elem;
            // since we have placed an item in index mCounts[current % NUM_DIGITS],
            // we need to increment mCounts[current % NUM_DIGITS] index by 1 so the
            // next duplicate digit is placed in appropriate index
            counts[current % NUM_DIGITS] += 1;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArray[i];
        }
    }

    public static void radixSort(int[] arr) {
        int minElem = Integer.MAX_VALUE;
        for (int elem : arr) {
            if (elem < minElem) {
                minElem = elem;
            }
        }
        
        // Do a shift in case the min value is negative
        if (minElem < 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] - minElem;
            }
        }

        int maxElem = Integer.MIN_VALUE;
        for (int elem : arr) {
            if (elem > maxElem) {
                maxElem = elem;
            }
        }

        int placeVal = 1;
        while (maxElem / placeVal > 0) {
            countingSort(arr, placeVal);
            placeVal *= 10;
        }

        // Restore accordingt to the shift
        if (minElem < 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] + minElem;
            }
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] input = in.readAllInts();
        radixSort(input);
        for (int i : input) {
            StdOut.printf("%d ", i);
        }
        StdOut.println();
    }
}