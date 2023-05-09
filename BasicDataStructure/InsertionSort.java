import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class InsertionSort {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currIdx = i;
            while (currIdx > 0 && (arr[currIdx] < arr[currIdx - 1])) {
                swap(arr, currIdx, currIdx-1);
                currIdx -= 1;
            }
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] input = in.readAllInts();
        insertionSort(input);
        for (int i : input) {
            StdOut.printf("%d ", i);
        }
        StdOut.println();
    }
}