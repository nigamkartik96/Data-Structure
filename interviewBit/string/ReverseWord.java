/**
 * Given an input string, reverse the string word by word.
 * <p>
 * Example:
 * <p>
 * Given s = "the sky is blue",
 * <p>
 * return "blue is sky the".
 * <p>
 * A sequence of non-space characters constitutes a word.
 * Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
 * If there are multiple spaces between words, reduce them to a single space in the reversed string.
 */
package string;

public class ReverseWord {
    public String reverseWords(String a) {
        String newLine = "";
        String word = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) != ' ') {
                word = a.charAt(i) + word;
            } else {
                word += " ";
                newLine += word;
                word = "";
            }
        }

        newLine += word + " ";
        return newLine.trim();
    }

    public static void main(String args[]) {
        ReverseWord obj = new ReverseWord();
        System.out.println(obj.reverseWords("the sky is blue"));
    }
}
