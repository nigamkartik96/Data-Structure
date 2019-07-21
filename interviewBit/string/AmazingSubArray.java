/**
 * You are given a string S, and you have to find all the amazing substrings of S.
 * <p>
 * Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
 * <p>
 * Input
 * <p>
 * Only argument given is string S.
 * Output
 * <p>
 * Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.
 * Constraints
 * <p>
 * 1 <= length(S) <= 1e6
 * S can have special characters
 * Example
 * <p>
 * Input
 * ABEC
 * <p>
 * Output
 * 6
 * <p>
 * Explanation
 * Amazing substrings of given string are :
 * 1. A
 * 2. AB
 * 3. ABE
 * 4. ABEC
 * 5. E
 * 6. EC
 * here number of substrings are 6 and 6 % 10003 = 6.
 */
package string;

public class AmazingSubArray {
    public int solve(String A) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            if (vowels.indexOf(a) != -1) {
                count = (count + A.length() - i) % 10003;
            }
        }

        return count;
    }

    public static void main(String args[]) {
        AmazingSubArray obj = new AmazingSubArray();
        System.out.println(obj.solve("ABEC"));
    }
}
