/**
 * There are N stairs, and a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top (order does not matter).
 * Note: Order does not matter means for n=4 {1 2 1},{2 1 1},{1 1 2} are considered same.
 *
 * Input:
 * The first line contains an integer 'T' denoting the total number of test cases. In each test cases, an integer N will be given.
 *
 * Output:
 * For each testcase, in a new line, print number of possible ways to reach Nth stair.
 *
 * Constraints:
 * 1 <= T <= 1000
 * 1 <= N <= 106
 *
 * Example:
 * Input:
 * 2
 * 4
 * 5
 * Output:
 * 3
 * 3
 *
 * Explanation:
 * Testcase 1: There are 3 ways to reach 4th stair.
 */

public class NumberOfStairs {

    Long countWays(int m) {
        long ways[] = new long[m + 1];
        ways[0] = 1;
        for (int i = 1; i <= m; i++) ways[i] += ways[i - 1];
        for (int i = 2; i <= m; i++) ways[i] += ways[i - 2];
        return ways[m];
    }

    public static void main(String args[]) {
        NumberOfStairs obj = new NumberOfStairs();
        System.out.println(obj.countWays(4));
    }
}
