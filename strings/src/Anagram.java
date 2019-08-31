/**
 * Given two strings a and b consisting of lowercase characters. The task is to check whether two given strings are anagram of each other or not. An anagram of a string is another string that contains same characters, only the order of characters can be different. For example, “act” and “tac” are anagram of each other.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Each test case consist of two strings in 'lowercase' only, in a single line.
 *
 * Output:
 * Print "YES" without quotes if the two strings are anagram else print "NO".
 *
 * Constraints:
 * 1 ≤ T ≤ 300
 * 1 ≤ |s| ≤ 1016
 *
 * Example:
 * Input:
 * 2
 * geeksforgeeks forgeeksgeeks
 * allergy allergic
 *
 * Output:
 * YES
 * NO
 *
 * Explanation:
 * Testcase 1: Both the string have same characters with same frequency. So, both are anagrams.
 * Testcase 2: Characters in both the strings are not same, so they are not anagrams.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- != 0) {
            String[] str = br.readLine().split(" ");
            if (str[0].length() != str[1].length()) {
                System.out.println("NO");
                continue;
            }
            int n = str[0].length(), a[] = new int[26], b[] = new int[26];

            for (int i = 0; i < n; i++) {
                a[str[0].charAt(i) - 'a']++;
                b[str[1].charAt(i) - 'a']++;
            }

            String result = "YES";
            for (int i = 0; i < 26; i++) {
                if (a[i] != b[i]) {
                    result = "NO";
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
