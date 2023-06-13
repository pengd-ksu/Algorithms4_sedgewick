import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class BubbleSort {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void bubbleSort(int[] arr, int len) {
        boolean hasSwapped = true;
        while (hasSwapped) {
            hasSwapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i + 1);
                    hasSwapped = true;
                }
            }
            // Every time for is done, the largest will
            // be pushed to the end, and valid length will 
            // decrement by one.
            len -= 1;
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] input = in.readAllInts();
        bubbleSort(input, input.length);
        for (int i : input) {
            StdOut.printf("%d ", i);
        }
        StdOut.println();
    }
}