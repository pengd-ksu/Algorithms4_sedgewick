import java.util.Arrays;

import edu.princeton.cs.algs4.In;

public class MergeSort {
    private static int[] merge_sort(int [] input) {
        if (input.length <= 1) return input;
        int mid = input.length / 2;
        int []left_sub = merge_sort(Arrays.copyOfRange(input, 0, mid));
        int []right_sub = merge_sort(Arrays.copyOfRange(input, mid, input.length));
        return merge(left_sub, right_sub);
    }
    
    private static int[] merge (int[] left, int[] right) {
        int [] res = new int[left.length + right.length];
        int lid = 0, rid = 0, resid = 0;
        while (lid < left.length && rid < right.length) {
            if (left[lid] < right[rid]) {
                res[resid++] = left[lid++];
            } else {
                res[resid++] = right[rid++];
            }
        }
        while (lid < left.length) {
            res[resid++] = left[lid++];
        }
        while (rid < right.length) {
            res[resid++] = right[rid++];
        }
        return res;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int []input = in.readAllInts();
        input = merge_sort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }
}