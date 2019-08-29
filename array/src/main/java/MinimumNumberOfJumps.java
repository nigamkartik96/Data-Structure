/**
 * Given an array of integers where each element represents the max number of steps that can be made forward from that element. The task is to find the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.
 *
 * Input:
 * The first line contains an integer T, depicting total number of test cases.  Then following T lines contains a number n denoting the size of the array. Next line contains the sequence of integers a1, a2, ..., an.
 *
 * Output:
 * For each testcase, in a new line, print the minimum number of jumps. If answer is not possible print "-1"(without quotes).
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 107
 * 0 <= ai <= 107
 *
 * Example:
 * Input:
 * 2
 * 11
 * 1 3 5 8 9 2 6 7 6 8 9
 * 6
 * 1 4 3 2 6 7
 * Output:
 * 3
 * 2
 *
 * Explanation:
 * Testcase 1: First jump from 1st element, and we jump to 2nd element with value 3. Now, from here we jump to 5h element with value 9. and from here we will jump to last.
 */

public class MinimumNumberOfJumps {
    public int getMinimumJumps(int arr[]) {
        int n = arr.length, jump[] = new int[n];
        for (int i = 1; i < n; i++) {
            jump[i] = Integer.MAX_VALUE - 1;
        }

        jump[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] + j >= i && jump[i] > jump[j] + 1) {
                    jump[i] = jump[j] + 1;
                }
            }
        }

        return jump[n - 1] == Integer.MAX_VALUE - 1 ? -1 : jump[n - 1];
    }

    public static void main(String args[]) {
        MinimumNumberOfJumps obj = new MinimumNumberOfJumps();
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(obj.getMinimumJumps(arr));
    }
}
