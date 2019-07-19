/**
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 *
 * Example:
 *
 *     A -> 1
 *
 *     B -> 2
 *
 *     C -> 3
 *
 *     ...
 *
 *     Z -> 26
 *
 *     AA -> 27
 *
 *     AB -> 28
 */
package maths;

public class TitleToNumber {
    public int titleToNumber(String A) {
        int sum = 0, p = A.length() - 1;
        for (int i = 0; i < A.length(); i++) {
            sum += ((int) Math.pow(26, p)) * (A.charAt(i) - 64);
            p--;
        }

        return sum;
    }

    public static void main(String args[]) {
        TitleToNumber obj = new TitleToNumber();
        System.out.println(obj.titleToNumber("AB"));
    }
}
