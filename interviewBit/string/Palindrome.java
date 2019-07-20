/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Example:
 *
 * "A man, a plan, a canal: Panama" is a palindrome.
 *
 * "race a car" is not a palindrome.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
package string;

public class Palindrome {
    public int isPalindrome(String A) {
        String b = A.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int start = 0, end = b.length() - 1;
        while (start < end) {
            if (b.charAt(start) != b.charAt(end)) break;
            start++;
            end--;
        }
        if (start >= end) return 1;
        else
            return 0;
    }

    public static void main(String args[]) {
        Palindrome obj = new Palindrome();
        System.out.println(obj.isPalindrome("ar, o, ra"));
    }
}
