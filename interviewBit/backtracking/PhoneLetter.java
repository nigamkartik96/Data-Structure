/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * The digit 0 maps to 0 itself.
 * The digit 1 maps to 1 itself.
 *
 * Input: Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Make sure the returned strings are lexicographically sorted.
 */
package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneLetter {
    public ArrayList<String> letterCombinations(String A) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        ArrayList<String> ans = new ArrayList<>();

        letterCombinationsHelper(A, ans, map, new StringBuilder(), 0);

        return ans;
    }

    private static void letterCombinationsHelper(String a, ArrayList<String> ans, Map<Integer, String> map, StringBuilder sb, int id) {
        if (id > a.length()) {
            return;
        }

        if (id == a.length() && sb.length() == a.length()) {
            ans.add(new StringBuilder(sb.toString()).toString());
        } else {
            for (int i = id; i < a.length(); i++) {
                String mapping = map.get(Integer.valueOf(String.valueOf(a.charAt(i))));
                for (int j = 0; j < mapping.length(); j++) {
                    // Choose
                    sb.append(mapping.charAt(j));

                    // Explore
                    letterCombinationsHelper(a, ans, map, sb, i + 1);

                    // Un-choose
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    public static void main(String args[]) {
        PhoneLetter obj = new PhoneLetter();
        System.out.println(obj.letterCombinations("23"));
    }
}
