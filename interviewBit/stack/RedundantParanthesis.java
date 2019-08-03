package stack;

import java.util.Stack;

public class RedundantParanthesis {
    public int braces(String a) {
        if (a.replaceAll("[()]", "").length() % 2 != 1) {
            return 1;
        }
        Stack<Character> stack = new Stack<Character>();
        int redundant = 0;
        String params = "+-/*";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '(') {
                stack.push('(');
            } else if (params.indexOf(a.charAt(i)) != -1) {
                stack.push(a.charAt(i));
            } else if (a.charAt(i) == ')') {
                int count = 0;
                while (!stack.empty() && stack.pop() != '(') {
                    count++;
                }
                if (count == 0) return 1;
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        RedundantParanthesis obj = new RedundantParanthesis();
        System.out.println(obj.braces("(a+b)"));
    }
}
