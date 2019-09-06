/**
 * Given an array arr[] of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
 *
 * Input Format:
 * The first line of input contains T, number of test cases. First line of line each test case contains a single integer N.
 * Next line contains N integer array.
 *
 * Output Format:
 * Print the output of each test case in a seprate line.
 *
 * Your Task:
 * This is a function problem. You only need to complete the function findLongestConseqSubseq that takes arr and n as parameters and retuns the length.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 105
 * 0 <= a[i] <= 105
 *
 * Example:
 * Input:
 * 2
 * 7
 * 2 6 1 9 4 5 3
 * 7
 * 1 9 3 10 4 20 2
 *
 * Output:
 * 6
 * 4
 *
 * Explanation:
 * Testcase 1:  The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.
 *
 * Testcase2: 1, 2, 3, 4 is the longest consecutive subsequence.
 */

import java.util.TreeSet;

public class LongestConsecutiveSubsequence {
    static int findLongestConseqSubseq(int arr[], int n) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) set.add(arr[i]);
        int k = 0, max = 1;
        for (int i : set) {
            int currMax = 1;
            k = i;
            while (set.contains(k + 1)) {
                k++;
                currMax++;
            }
            if (currMax > max) max = currMax;
            if (set.size() - currMax <= set.size() / 2) break;
        }
        return max;
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5}, n = arr.length;
        System.out.println(findLongestConseqSubseq(arr, n));
    }
}
