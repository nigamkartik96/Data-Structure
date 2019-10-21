/**
 * A frog jumps either 1, 2 or 3 steps to go to top. In how many ways can it reach the top.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. T testcases follow. Each testcase contains one line of input N denoting the total number of steps.
 *
 * Output:
 * For each testcase, in a new line, print the number of ways to reach the top.
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 50
 *
 * Example:
 * Input:
 * 2
 * 1
 * 5
 * Output:
 * 1
 * 13
 */

import java.util.Scanner;

public class NumberOfHops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            int goal = sc.nextInt();
            System.out.println(getWays(goal));
        }
    }

    static int getWays(int goal) {
        if (goal == 1) return 1;
        if (goal == 2) return 2;
        if (goal == 3) return 4;

        int[] ways = new int[goal + 1];
        ways[1] = 1;
        ways[2] = 2;
        ways[3] = 4;
        for (int i = 4; i <= goal; i++) {
            ways[i] = ways[i - 1] + ways[i - 2] + ways[i - 3];
        }
        return ways[goal];
    }
}
