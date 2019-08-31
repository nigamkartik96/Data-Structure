/**
 * Given a string S, find length of the longest substring with all distinct characters.  For example, for input "abca", the output is 3 as "abc" is the longest substring with all distinct characters.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases.
 * The first line of each test case is String str.
 *
 * Output:
 * Print length of smallest substring with maximum number of distinct characters.
 * Note: The output substring should have all distinct characters.
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ size of str ≤ 10000
 *
 * Example:
 * Input:
 * 2
 * abababcdefababcdab
 * geeksforgeeks
 *
 * Output:
 * 6
 * 7
 */

import java.util.Scanner;

public class DistinctSubString {
    static final int CHAR_SIZE = 256;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            String string = sc.next();
            System.out.println(getSize(string));
        }
    }

    public static int getSize(String str) {
        int visited[] = new int[CHAR_SIZE];
        int n = str.length();
        for (int i = 0; i < CHAR_SIZE; i++) {
            visited[i] = -1;
        }

        int currLen = 1, max = Integer.MIN_VALUE;

        visited[str.charAt(0)] = 0;
        for (int i = 1; i < n; i++) {
            int prev = visited[str.charAt(i)];
            if (prev == -1 || i - currLen > prev) currLen++;
            else {
                if (currLen > max) max = currLen;
                currLen = i - prev;
            }

            visited[str.charAt(i)] = i;
        }

        if (currLen > max) max = currLen;

        return max;
    }
}
