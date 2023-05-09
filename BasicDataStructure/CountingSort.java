import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class CountingSort {
    public static void countingSort(int[] arr) {
        int shift = Arrays.stream(arr).min().getAsInt();
        int k = Arrays.stream(arr).max().getAsInt() - shift;
        int[] counts = new int[k+1];
        for (int elem : arr) {
            counts[elem - shift] += 1;
        }
        // Overwrite with cumulative counts on previous elem
        int startIdx = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            counts[i] = startIdx;
            startIdx += count;
        }
        // Now we have the beginning of the cumulative elem's index
        // We will update the index every time we put one elem according
        // to its order, since next same elem will be put after current.
        int[] sortedArray = new int[arr.length];
        for (int elem : arr) {
            sortedArray[counts[elem - shift]] = elem;
            // Update next same elem's index
            counts[elem - shift]++;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArray[i];
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] input = in.readAllInts();
        countingSort(input);
        for (int i : input) {
            StdOut.printf("%d ", i);
        }
        StdOut.println();
    }
}