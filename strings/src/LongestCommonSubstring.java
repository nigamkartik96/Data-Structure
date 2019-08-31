/**
 * Given two strings X and Y. The task is to find the length of the longest common substring.
 *
 * Input:
 * First line of the input contains number of test cases T. Each test case consist of three lines, first of which contains 2 space separated integers N and M denoting the size of string X and Y strings respectively. The next two lines contains the string X and Y.
 *
 * Output:
 * For each test case print the length of longest  common substring of the two strings .
 *
 * Constraints:
 * 1 <= T <= 200
 * 1 <= N, M <= 100
 *
 * Example:
 * Input:
 * 2
 * 6 6
 * ABCDGH
 * ACDGHR
 * 3 2
 * ABC
 * AC
 *
 * Output:
 * 4
 * 1
 */

import java.util.Scanner;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            String s1 = sc.next();
            String s2 = sc.next();

            System.out.println(getLen(s1, s2, n, m));
        }
    }

    public static int getLen(String a, String b, int n, int m) {
        int[][] matrix = new int[n + 1][m + 1];
        int result = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 0 || j == 0) matrix[i][j] = 0;
                else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    result = Math.max(result, matrix[i][j]);
                } else {
                    result = Math.max(result, matrix[i][j]);
                    matrix[i][j] = 0;
                }
            }
        }

        return result;
    }
}
