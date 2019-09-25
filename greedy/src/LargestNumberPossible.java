/**
 * Given two numbers 'N' and 'S' , find the largest number that can be formed with 'N' digits and whose sum of digits should be equals to 'S'.
 * <p>
 * <p>
 * Input
 * <p>
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case contains two space separated integers N and S, where N is the number of digits and S is the sum.
 * <p>
 * <p>
 * Output
 * <p>
 * Print the largest number that is possible.
 * If their is no such number, then print -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= T <= 30
 * 1 <= N <= 50
 * 0 <= S <= 500
 * <p>
 * <p>
 * Example
 * <p>
 * Input
 * 2
 * 2 9
 * 3 20
 * <p>
 * Output
 * <p>
 * 90
 * 992
 * <p>
 * Expected Time Complexity: O(n)
 */

import java.util.Scanner;

public class LargestNumberPossible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            int n = sc.nextInt(), s = sc.nextInt();
            String val = "";
            if (s == 0 && n != 0) {
                System.out.println(-1);
                continue;
            }
            for (int i = 1; i <= n; i++) {
                if (s > 9) {
                    val = val + 9;
                    s -= 9;
                } else {
                    val = val + s;
                    s -= s;
                }
            }
            if (s != 0) System.out.println(-1);
            else System.out.println(val);
        }
    }
}
