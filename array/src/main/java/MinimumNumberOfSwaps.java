/**
 * Given an array of N distinct elementsA[ ]. The task is to find the minimum number of swaps required to sort the array. Your are required to complete the function which returns an integer denoting the minimum number of swaps, required to sort the array.
 *
 * Input:
 * The first line of input contains an integer T denoting the no of test cases . Then T test cases follow . Each test case contains an integer N denoting the no of element of the array A[ ]. In the next line are N space separated values of the array A[ ] .
 *
 * Output:
 * For each test case in a new line output will be an integer denoting  minimum umber of swaps that are  required to sort the array.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 103
 * 1 <= A[] <= 104
 *
 *
 * User Task: Your task is to complete minSwaps() which should return number of swaps required to make the array elements sorted.
 *
 * Example(To be used only for expected output):
 * Input:
 * 2
 * 4
 * 4 3 2 1
 * 5
 * 1 5 4 3 2
 *
 * Output:
 * 2
 * 2
 *
 * Explanation:
 * Testcase 1: We need two swaps, swap 1 with 4 and 3 with 2 to make it sorted.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MinimumNumberOfSwaps {
    class Pair {
        int pos, val;

        Pair(int pos, int val) {
            this.pos = pos;
            this.val = val;
        }

        public int getPos() {
            return pos;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "pos=" + pos +
                    ", val=" + val +
                    '}';
        }

        public int getVal() {
            return val;
        }
    }

    private int getMinimumSwaps(int[] arr) {
        int n = arr.length;
        ArrayList<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(i, arr[i]));
        }

        Collections.sort(pairs, Comparator.comparingInt(o -> o.getVal()));
        boolean visited[] = new boolean[n];
//        System.out.println(pairs);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int pos = pairs.get(i).getPos();
            visited[i] = true;
            int cycle = 0;
            while (!visited[pos]) {
                visited[pos] = true;
                pos = pairs.get(pos).getPos();
                cycle++;
            }
            if (cycle > 0)
                sum += cycle;
        }

        return sum;
    }

    public static void main(String ars[]) {
        MinimumNumberOfSwaps obj = new MinimumNumberOfSwaps();
        int arr[] = {4, 3, 2, 1};
        System.out.println(obj.getMinimumSwaps(arr));
    }
}
