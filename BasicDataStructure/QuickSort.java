import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class QuickSort {
    private static void quickSort(int [] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2, last = left, id = left+1;
        swap(left, mid, nums);
        while (id <= right) {
            if (nums[id] < nums[left]) {
                swap(id, ++last, nums);
            }
            id++;
        }
        swap(last, left, nums);
        quickSort(nums, left, last - 1);
        quickSort(nums, last + 1, right);
    }
    private static void swap (int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main (String []args) {
        In in = new In(args[0]);
        int[] input = in.readAllInts();
        quickSort(input, 0, input.length - 1);
        for (int i : input) {
            StdOut.printf("%d ", i);
        }
        StdOut.println();
    }
}