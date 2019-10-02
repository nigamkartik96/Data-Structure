/**
 * Given a string str containing alphanumeric characters, calculate sum of all numbers present in the string.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains a string containing alphanumeric characters.
 *
 * Output:
 * Print the sum of all numbers present in the string.
 *
 * Constraints:
 * 1<=T<=105
 * 1<=length of the string<=105
 *
 * Example:
 * Input:
 * 4
 * 1abc23
 * geeks4geeks
 * 1abc2x30yz67
 * 123abc
 *
 * Output:
 * 24
 * 4
 * 100
 * 123
 *
 * Explanation:
 * Testcase 1: 1 and 23 are numbers in the string which is added to get the sum as 24.
 * Testcase 4: 123 is a single number, so sum is 123.
 */

import java.util.Scanner;

public class CalculateSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            String s = sc.next();
            System.out.println(getSum(s));
        }
    }

    static private int getSum(String s) {
        String number = "";
        char ch;
        String numbers = "0123456789";
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (numbers.indexOf(ch) != -1) {
                number += ch;
            } else {
                if (number.length() != 0) {
                    sum += Integer.parseInt(number);
                }
                number = "";
            }
        }

        if (number.length() != 0) sum += Integer.parseInt(number);
        return sum;
    }
}
