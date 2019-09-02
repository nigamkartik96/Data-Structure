/**
 * Given a string S with repeated characters (only lowercase). The task is to rearrange characters in a string such that no two adjacent characters are same.
 *
 * Note : It may be assumed that the string has only lowercase English alphabets.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains a single line containing a string of lowercase english alphabets.
 *
 * Output:
 * For each test case in a new line print "1" (without quotes) if the generated string doesn't contains any same adjacent characters, else if no such string is possible to be made print "0" (without quotes).
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= length of string <= 104
 *
 * Example:
 * Input:
 * 3
 * geeksforgeeks
 * bbbabaaacd
 * bbbbb
 *
 * Output:
 * 1
 * 1
 * 0
 *
 * Explanation:
 * Testcase 1: All the repeated characters of the given string can be rearranged so that no adjacent characters in the string is equal.
 * Testcase 3: Repeated characters in the string cannot be rearranged such that there should not be any adjacent repeated character.
 */

import java.util.Scanner;

public class RearrangeCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            String s = sc.next();
            int n = s.length();
            char ch = isPossible(s);
            int count = getMajority(ch, s);

            if (n % 2 == 1 && ((n + 1) / 2) >= count) {
                System.out.println(1);
                continue;
            }
            if (n % 2 == 0 && (n / 2) >= count) {
                System.out.println(1);
                continue;
            }
            System.out.println(0);
        }
    }

    public static int getMajority(char ch, String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) count++;
        }

        return count;
    }

    public static char isPossible(String s) {
        int count = 0, index = 0;
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.charAt(index) == ch) {
                count++;
            } else count--;

            if (count <= 0) {
                count = 1;
                index = i;
            }
        }

        return s.charAt(index);
    }
}
