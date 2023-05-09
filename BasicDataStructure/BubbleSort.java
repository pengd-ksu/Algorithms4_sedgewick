import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class BubbleSort {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void selectionSort(int[] arr) {
        boolean hasSwapped = true;
        while (hasSwapped) {
            hasSwapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i + 1);
                    hasSwapped = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] input = in.readAllInts();
        selectionSort(input);
        for (int i : input) {
            StdOut.printf("%d ", i);
        }
        StdOut.println();
    }
}