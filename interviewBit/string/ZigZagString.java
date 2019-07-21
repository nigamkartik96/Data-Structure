/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P.......A........H.......N
 * ..A..P....L....S....I...I....G
 * ....Y.........I........R
 * And then read line by line: PAHNAPLSIIGYIR
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 * **Example 2 : **
 * ABCD, 2 can be written as
 *
 * A....C
 * ...B....D
 * and hence the answer would be ACBD.
 */
package string;

public class ZigZagString {
    public String convert(String A, int B) {
        if (B == 1) return A;
        String[] strings = new String[B];
        for (int i = 0; i < B; i++) {
            strings[i] = "";
        }
        int val = 0;
        boolean flag = false;
        for (int i = 0; i < A.length(); i++) {
            if (val == B - 1) {
                flag = false;
            } else if (val == 0) {
                flag = true;
            }
            if (!flag) {
                strings[val--] += A.charAt(i);
            } else {
                strings[val++] += A.charAt(i);
            }
        }
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < B; i++) {
            newString.append(strings[i]);
        }
        return newString.toString();
    }

    public static void main(String args[]) {
        ZigZagString obj = new ZigZagString();
        System.out.println(obj.convert("ABCD", 2));
    }
}
