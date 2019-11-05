/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import java.util.HashSet;

public class LongestNonRepeating {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int current = 1;
        int max = 1;
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                j++;
                i = j;
                current = 1;
                set = new HashSet<>();
                set.add(s.charAt(j));
            } else {
                current++;
                set.add(ch);
                if (current > max) max = current;
            }
        }

        return max;
    }

    public static void main(String args[]) {
        LongestNonRepeating obj = new LongestNonRepeating();
        System.out.println(obj.lengthOfLongestSubstring("abcaabhi"));
    }
}
