/**
 * You are given a string. The only operation allowed is to insert characters in the beginning of the string. How many minimum characters are needed to be inserted to make the string a palindrome string
 *
 * Example:
 * Input: ABC
 * Output: 2
 * Input: AACECAAAA
 * Output: 2
 */
package string;

public class MinimumRequiredPalindrome {
    public static void main(String args[]) {
        MinimumRequiredPalindrome obj = new MinimumRequiredPalindrome();
        System.out.println(obj.minimumPalindrome("hqghumeaylnlfdxfi"));
        System.out.println(obj.minimumPalindrome("AACECAA"));
    }

    public int minimumPalindrome(String A) {
        int start = 0, end = A.length() - 1;
        int prev = 0;
        int backup = 0;
        while (start < end) {
            if (A.charAt(start) == A.charAt(end)) {
                start++;
                backup++;
            } else {
                prev++;

                start = 0;

                if (A.charAt(start) == A.charAt(end)) {
                    start++;
                } else {
                    prev += backup;
                    backup = 0;
                }
            }

            end--;
        }
        return prev;
    }
}
