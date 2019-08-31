/**
 * Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index ).
 *
 * NOTE: Required Time Complexity O(n2).
 *
 * Input:
 * The first line of input consists number of the testcases. The following T lines consist of a string each.
 *
 * Output:
 * In each separate line print the longest palindrome of the string given in the respective test case.
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ Str Length ≤ 104
 *
 * Example:
 * Input:
 * 1
 * aaaabbaa
 *
 * Output:
 * aabbaa
 *
 * Explanation:
 * Testcase 1: The longest palindrome string present in the given string is "aabbaa".
 */

import java.util.Scanner;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            String str = sc.next();
            System.out.println(getLen(str));
        }
    }

    public static String getLen(String str) {
        String result = str.charAt(0) + "";
        int n = str.length();
        for (int i = 0; i < n; i++) {
            String odd = getPalindromeLen(str, n, i - 1, i + 1);
            String even = getPalindromeLen(str, n, i - 1, i);
            String greater = odd.length() > even.length() ? odd : even;
            result = result.length() >= greater.length() ? result : greater;
        }

        return result;
    }

    public static String getPalindromeLen(String str, int n, int i, int j) {
        String s = "";
        while (i != -1 && j != n) {
            if (str.charAt(i) != str.charAt(j)) break;
            s = str.substring(i, j + 1);
            i--;
            j++;
        }
        return s;
    }
}
