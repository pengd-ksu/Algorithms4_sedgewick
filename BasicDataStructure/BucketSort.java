import java.util.*;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class BucketSort {
    public static void bucketSort(int[] arr, int K) {
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            buckets.add(new ArrayList<>());
        }
        int shift = Arrays.stream(arr).min().getAsInt();
        int maxValue = Arrays.stream(arr).max().getAsInt() - shift;
        // place elements into buckets
        double bucketSize = (double) maxValue / K;
        if (bucketSize < 1) {
            bucketSize = 1.0;
        }
        for (int elem : arr) {
            // same as K * arr[i] / max(lst)
            int index = (int) ((elem - shift) / bucketSize);
            if (index == K) {
                // put the max value in the last bucket
                buckets.get(K-1).add(elem);
            } else {
                buckets.get(index).add(elem);
            }
        }

        // sort individual buckets
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // convert sorted buckets into final output
        List<Integer> sortedList = new ArrayList<Integer>();
        for (List<Integer> bucket : buckets) {
            sortedList.addAll(bucket);
        }

        // perfectly fine to just return sortedList here
        // but common practice is to mutate original array with sorted elements
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedList.get(i);
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] input = in.readAllInts();
        bucketSort(input, 5);
        for (int i : input) {
            StdOut.printf("%d ", i);
        }
        StdOut.println();
    }
}