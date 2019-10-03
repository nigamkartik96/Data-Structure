/**
 * Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words. See following examples for more details.
 *
 * Consider the following dictionary
 * { i, like, sam, sung, samsung, mobile, ice,
 *   cream, icecream, man, go, mango}
 *
 * Input:  ilike
 * Output: Yes
 * The string can be segmented as "i like".
 *
 * Input:  ilikesamsung
 * Output: Yes
 * The string can be segmented as "i like samsung" or "i like sam sung".
 *
 * Input:
 * First line is integer T denoting number of test cases. 1<=T<=100.
 * Every test case has 3 lines.
 * First line is N number of words in dictionary. 1<=N<=12.
 * Second line contains N strings denoting the words of dictionary. Length of each word is less than 15.
 * Third line contains a string S of length less than 1000.
 *
 * Output:
 * Print 1 is possible to break words, else print 0.
 *
 * Example:
 * Input:
 * 2
 * 12
 * i like sam sung samsung mobile ice cream icecream man go mango
 * ilike
 * 12
 * i like sam sung samsung mobile ice cream icecream man go mango
 * idontlike
 * Output:
 * 1
 * 0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordExist {
    static class TrieNode {
        boolean endOfWord;
        TrieNode[] characters;

        TrieNode() {
            characters = new TrieNode[26];
            endOfWord = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- != 0) {
            int n = Integer.parseInt(br.readLine());
            String s1[] = br.readLine().split(" ");
            String s = br.readLine();
            TrieNode root = new TrieNode();
            for (int i = 0; i < n; i++) {
                insertWord(s1[i].toLowerCase(), root);
            }
            System.out.println(matchWord(root, s.toLowerCase()));
        }
    }

    public static void insertWord(String word, TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 97;
            TrieNode temp = null;
            if (node.characters[ch] == null) {
                temp = new TrieNode();
            } else {
                temp = node.characters[ch];
            }
            if (i == word.length() - 1) {
                temp.endOfWord = true;
            }

            node.characters[ch] = temp;
            node = temp;
        }
    }

    public static int matchWord(TrieNode root, String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 97;

            if (node.characters[ch] == null) {
                return 0;
            } else {
                if (node.characters[ch].endOfWord) {
                    if (i == word.length() - 1) return 1;
                    node = root;
                } else node = node.characters[ch];
            }
        }
        return 0;
    }
}
