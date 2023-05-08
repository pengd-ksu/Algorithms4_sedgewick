import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class HeapSort {
    public static void heapSort(int [] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            // First arr will decrease size by one, and at each iteration,
            // it will decrease one too.
            maxHeapify(arr, i, 0);
        }
    }

    public static void maxHeapify(int[] arr, int heapSize, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != index) {
            int tmp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = tmp;
            maxHeapify(arr, heapSize, largest);
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] arr = in.readAllInts();
        heapSort(arr);
        for (int n : arr) {
            StdOut.printf("%d ", n);
        }
        StdOut.println();
    }
}