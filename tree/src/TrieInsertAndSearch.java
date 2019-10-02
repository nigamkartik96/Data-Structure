/**
 * Trie is an efficient information retrieval data structure. Use this data structure to store Strings and search strings. Your task is to use TRIE data structure and search the given string A. If found print 1 else 0.
 *
 * Input:
 * The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consists of three lines.
 * First line of each test case consist of a integer N, denoting the number of element in a Trie to be stored.
 * Second line of each test case consists of N space separated strings denoting the elements to be stored in the trie.
 * Third line of each test case consists of a String A to be searched in the stored elements.
 *
 * Output:
 * Print the respective output in the respective line.
 *
 * Constraints:
 * 1<=T<=20
 * 1<=N<=20
 *
 * Example:
 * Input:
 * 1
 * 8
 * the a there answer any by bye their
 * the
 * Output:
 * 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrieInsertAndSearch {
    static class TrieNode {
        TrieNode[] characters;
        boolean endOfWord;

        TrieNode() {
            characters = new TrieNode[26];
            this.endOfWord = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- != 0) {
            int n = Integer.parseInt(br.readLine());
            String s[] = br.readLine().split(" ");
            String search = br.readLine();
            TrieNode root = new TrieNode();

            for (int i = 0; i < n; i++) {
                insertWord(s[i], root);
            }

            System.out.println(searchWord(search, root) ? 1 : 0);
        }
    }

    private static boolean searchWord(String word, TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 97;
            if (node.characters[ch] == null) return false;
            node = node.characters[ch];
        }
        return node.endOfWord;
    }

    private static void insertWord(String word, TrieNode root) {
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
}
