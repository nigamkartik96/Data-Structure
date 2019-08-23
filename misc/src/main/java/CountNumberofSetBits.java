/**
 * You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. T testcases follow. The first line of each test case is N.
 *
 * Output:
 * For each testcase, in a new line, print the total count of all bits.
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 103
 *
 * Example:
 * Input:
 * 2
 * 4
 * 17
 * Output:
 * 5
 * 35
 *
 * Explanation:
 * Testcase1:
 * An easy way to look at it is to consider the number, n = 4:
 * 0 0 0 = 0
 * 0 0 1 = 1
 * 0 1 0 = 1
 * 0 1 1 = 2
 * 1 0 0 = 1
 * Therefore , the total number of bits is 5.
 */

import java.util.Scanner;

public class CountNumberofSetBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            int n = sc.nextInt();
            int count = 0;
            for (int i = 1; i <= n; i++) {
                count += countBits(i);
            }
            System.out.println(count);
        }
    }

    static int countBits(int n) {
        int[] t = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
        int count = 0;
        while (n != 0) {
            count += t[n & 0xF];
            n >>= 4;
        }

        return count;
    }
}
