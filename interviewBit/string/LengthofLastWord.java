/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Given s = "Hello World",
 *
 * return 5 as length("World") = 5.
 *
 * Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.
 */
package string;

public class LengthofLastWord {
    public int lengthOfLastWord(final String A) {
        int len = 0;
        String a = A.trim();
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == ' ') break;
            len ++;
        }

        return len;
    }

    public static void main(String args[]) {
        LengthofLastWord obj = new LengthofLastWord();
        System.out.println(obj.lengthOfLastWord("Hello Worlds"));
    }
}
