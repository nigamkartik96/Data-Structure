/**
 * Given an expression string exp. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
 * For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases.  Each test case consists of a string of expression, in a separate line.
 *
 * Output:
 * Print 'balanced' without quotes if the pair of parenthesis is balanced else print 'not balanced' in a separate line.
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ |s| ≤ 105
 *
 * Example:
 * Input:
 * 3
 * {([])}
 * ()
 * ([]
 *
 * Output:
 * balanced
 * balanced
 * not balanced
 */

import java.util.Scanner;
import java.util.Stack;

public class Paranthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            String s = sc.next();
            System.out.println(checkParanthesis(s));
        }
    }

    public static String checkParanthesis(String s) {
        int n = s.length();
        if (n == 0) return "balanced";
        Stack<Character> stack = new Stack<>();

        String openers = "{[(";


        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (openers.indexOf(ch) != -1) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return "not balanced";
                char temp = stack.pop();
                if (temp != getOpener(ch)) return "not balanced";
            }
        }

        if (stack.isEmpty()) return "balanced";
        else return "not balanced";
    }

    public static char getOpener(char ch) {
        switch (ch) {
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
        }

        return ' ';
    }
}
