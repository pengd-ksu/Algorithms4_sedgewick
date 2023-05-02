import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int minIdx;
        for (int i = 0; i < arr.length; i++) {
            minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp; 
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