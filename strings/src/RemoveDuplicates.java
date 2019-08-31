/**
 * Given a string s, recursively remove adjacent duplicate characters from the string s. The output string should not have any adjacent duplicates.
 *
 *
 * Input:
 * The first line of input contains an integer T, denoting the no of test cases. Then T test cases follow. Each test case contains a string str.
 *
 * Output:
 * For each test case, print a new line containing the resulting string.
 *
 * Constraints:
 * 1<=T<=100
 * 1<=Length of string<=50
 *
 * Example:
 * Input:
 * 2
 * geeksforgeek
 * acaaabbbacdddd
 *
 * Output:
 * gksforgk
 * acac
 */

import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            String str = sc.next();
            System.out.println(removeUtil(str, '\0'));

        }
    }

    public static String removeUtil(String str, char last_removed) {
        if (str.length() == 0 || str.length() == 1)
            return str;
        if (str.charAt(0) == str.charAt(1)) {
            last_removed = str.charAt(0);
            while (str.length() > 1 && str.charAt(0) == str.charAt(1))
                str = str.substring(1, str.length());
            str = str.substring(1, str.length());
            return removeUtil(str, last_removed);
        }

        String rem_str = removeUtil(str.substring(1, str.length()), last_removed);

        if (rem_str.length() != 0 && rem_str.charAt(0) == str.charAt(0)) {
            last_removed = str.charAt(0);
            return rem_str.substring(1, rem_str.length());
        }

        if (rem_str.length() == 0 && last_removed == str.charAt(0))
            return rem_str;

        return (str.charAt(0) + rem_str);
    }
}
