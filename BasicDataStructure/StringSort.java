import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class StringSort {
    public static void sortByLength(String[] arr) {
        // Sorts a list of string by length of each
        Arrays.sort(arr, new StringCompare());
    }

    public static class StringCompare implements Comparator<String> {
        public int compare (String s1, String s2) {
            if (s1.length() > s2.length()) {
                return 1;
            } else if (s1.length() < s2.length()) {
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        String [] input = in.readAllStrings();
        sortByLength(input);
        for (String s : input) {
            StdOut.printf("%s ", s);
        }
        StdOut.println();
    }
}