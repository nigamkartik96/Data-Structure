/**
 * Given a string S and text T. Output the smallest window in the string S having all characters of the text T. Both the string S and text T contains lowercase english alphabets.
 *
 * Input:
 * First line of the input contains an integer T, denoting the number of test cases. Then T test case follows. Each test contains 2 lines having a string S and next line contains text T.
 *
 * Output:
 * Output the smallest window of the string containing all the characters of the text. If such window doesn`t exist or this task can not be done then print -1.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= |N|, |X| <= 1000
 *
 * Example:
 * Input:
 * 2
 * timetopractice
 * toc
 * zoomlazapzo
 * oza
 *
 * Output:
 * toprac
 * apzo
 *
 * Explanation:
 * Testcase 1: "toprac" is the smallest substring in the given string S which contains every characters of T.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SmallestWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            String text = sc.next();
            String subText = sc.next();
            System.out.println(minWindow(text, subText));
        }
    }

    public static String minWindow(String searchString, String t) {

        Map<Character, Integer> requiredCharacters = buildMappingOfCharactersToOccurrences(t);
        Map<Character, Integer> windowCharacterMapping = new HashMap<>();
        int left = 0;
        int right = 0;
        int totalCharFrequenciesToMatch = requiredCharacters.size();
        int charFrequenciesInWindowThatMatch = 0;
        int minWindowLengthSeenSoFar = Integer.MAX_VALUE;
        String minWindow = "";

        while (right < searchString.length()) {
            char characterAtRightPointer = searchString.charAt(right);
            addCharacterToHashtableMapping(windowCharacterMapping, characterAtRightPointer);
            boolean rightCharIsARequirement = requiredCharacters.containsKey(characterAtRightPointer);
            if (rightCharIsARequirement) {
                boolean requirementForCharacterMet = requiredCharacters.get(characterAtRightPointer).intValue() ==
                        windowCharacterMapping.get(characterAtRightPointer).intValue();
                if (requirementForCharacterMet) {
                    charFrequenciesInWindowThatMatch++;
                }
            }
            while (charFrequenciesInWindowThatMatch == totalCharFrequenciesToMatch && left <= right) {
                char characterAtLeftPointer = searchString.charAt(left);
                int windowSize = right - left + 1;
                if (windowSize < minWindowLengthSeenSoFar) {
                    minWindowLengthSeenSoFar = windowSize;
                    minWindow = searchString.substring(left, right + 1);
                }
                windowCharacterMapping.put(characterAtLeftPointer, windowCharacterMapping.get(characterAtLeftPointer) - 1);
                boolean leftCharIsARequirement = requiredCharacters.containsKey(characterAtLeftPointer);
                if (leftCharIsARequirement) {
                    boolean characterFailsRequirement = windowCharacterMapping.get(characterAtLeftPointer).intValue() <
                            requiredCharacters.get(characterAtLeftPointer).intValue();

                    if (characterFailsRequirement) {
                        charFrequenciesInWindowThatMatch--;
                    }
                }
                left++;
            }
            right++;
        }

        return minWindow;
    }

    private static Map<Character, Integer> buildMappingOfCharactersToOccurrences(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            int occurrencesOfCharacter = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), occurrencesOfCharacter + 1);
        }

        return map;
    }

    private static void addCharacterToHashtableMapping(Map<Character, Integer> map, Character c) {
        int occurrences = map.getOrDefault(c, 0);
        map.put(c, occurrences + 1);
    }
}
