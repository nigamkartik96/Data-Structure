/**
 * Given an integer N, how many structurally unique binary search trees are there that store values 1...N?
 *
 * Input:
 * First line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains a single line of input containing N.
 *
 * Ouput:
 * For each testcase, in a new line, print the answer.
 *
 * Constraints:
 * 1<=T<=15
 * 1<=N<=11
 *
 * Example:
 * Input:
 * 2
 * 2
 * 3
 * Output:
 * 2
 * 5
 *
 * Explanation:
 *
 * Testcase1:
 * for N = 2, there are 2 unique BSTs
 *      1               2
 *       \            /
 *        2         1
 *
 * Testcase2:
 * for N = 3, there are 5 possible BSTs
 *   1              3        3         2      1
 *     \           /        /           /    \      \
 *      3        2         1        1    3      2
 *     /       /                \                      \
 *    2      1               2                        3
 */
public class UniqueBSTs {
    static int numTrees(int n) {
        int arr[] = new int[n + 1];
        arr[0] = arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                arr[i] += arr[j - 1] * arr[i - j];
            }
        }
        return arr[n];
    }

    public static void main(String args[]) {
        System.out.println(numTrees(3));
    }
}
