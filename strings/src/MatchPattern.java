/**
 * Given a dictionary of words and a pattern. Every character in the pattern is uniquely mapped to a character in the dictionary. The task is to complete a function findMatchedWords(dict,pattern) that returns a vector of strings matching with given pattern. The function takes two argument the first argument is an array of strings dict which denote the dictionary and the second argument is the pattern to match.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Each testcase contains 3 lines. The first line contains an integer N denoting the number of strings in the dictionary,second line N space separated strings denoting the strings of the dictionary. The third line contains pattern.
 *
 * Output:
 * The output for each test case will be the space separated strings that matches the given pattern in lexicographical order.
 *
 * User Task:
 * Since this is a functional problem you don't have to worry about input, you just have to complete the function findMatchedWords()
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 10
 *
 * Input
 * 1
 * 4
 * abb abc xyz xyy
 * foo
 *
 * Output
 * abb xyy
 *
 * Explanation
 * Testcase 1: In the above test case xyy and abb have same character at index 1 and 2 like the pattern.
 */

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class MatchPattern {
    public static ArrayList<String> findMatchedWords
            (ArrayList<String> dict, String pattern) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        ArrayList<String> matchedPatterns = new ArrayList<>();

        getMap(map, pattern);
        String actualPattern = getPattern(map);

        for (String word : dict) {
            map = new LinkedHashMap<>();
            getMap(map, word);
            String newPattern = getPattern(map);

            if (actualPattern.equals(newPattern)) {
                matchedPatterns.add(word);
            }
        }

        return matchedPatterns;
    }

    static void getMap(LinkedHashMap<Character, Integer> map, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
        }
    }

    static String getPattern(LinkedHashMap<Character, Integer> map) {
        StringBuilder pattern = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pattern.append(entry.getValue());
        }

        return pattern.toString();
    }

    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<>();
        list.add("abb");
        list.add("bbb");
        System.out.println(findMatchedWords(list, "bcc"));
    }
}
