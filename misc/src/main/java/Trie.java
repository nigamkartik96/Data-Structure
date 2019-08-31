/**
 * Given a array of N strings, find the longest common prefix among all strings present in the array.
 *
 * Input:
 * The first line of the input contains an integer T which denotes the number of test cases to follow. Each test case contains an integer N. Next line has space separated N strings.
 *
 * Output:
 * Print the longest common prefix as a string in the given array. If no such prefix exists print "-1"(without quotes).
 *
 * Constraints:
 * 1 <= T <= 103
 * 1 <= N <= 103
 * 1 <= |S| <= 103
 *
 * Example:
 * Input:
 * 2
 * 4
 * geeksforgeeks geeks geek geezer
 * 3
 * apple ape april
 *
 * Output:
 * gee
 * ap
 *
 * Explanation:
 * Testcase 1: Longest common prefix in all the given string is gee.
 */

import java.util.Arrays;

public class Trie {
    static final int ALPHABET_SIZE = 26;

    static class Node {
        Node[] children = new Node[ALPHABET_SIZE];
        boolean isEndOfWord;

        @Override
        public String toString() {
            return "Node{" +
                    "children=" + Arrays.toString(children) +
                    ", isEndOfWord=" + isEndOfWord +
                    '}';
        }

        Node() {
            this.isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                this.children[i] = null;
            }
        }
    }

    static Node trie = new Node();

    public void insertWord(String word) {
        word = word.toLowerCase();
        int n = word.length();
        int index;

        Node crawler = trie;
        for (int level = 0; level < n; level++) {
            index = word.charAt(level) - 'a';
            if (crawler.children[index] == null) {
                crawler.children[index] = new Node();
            }
            crawler = crawler.children[index];
        }

        crawler.isEndOfWord = true;
    }

    public boolean searchWord(String word) {
        int level;
        int n = word.length();
        word = word.toLowerCase();
        int index;

        Node crawler = trie;
        for (level = 0; level < n; level++) {
            index = word.charAt(level) - 'a';
            if (crawler.children[index] == null) return false;
            crawler = crawler.children[index];
        }

        if (crawler.isEndOfWord) return true;
        return false;
    }

    public boolean isSingleNode(Node node) {
        int count = 0;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (node.children[i] != null) {
                count++;
            }
            if (count == 2) {
                return false;
            }
        }

        return true;
    }

    public int getIndex(Node node) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (node.children[i] != null) return i;
        }
        return -1;
    }

    public void completeTrie(String[] words) {
        for (int i = 0; i < words.length; i++) {
            insertWord(words[i]);
        }
    }

    public int getLastSingleIndex() {
        Node crawler = trie;
        int index = 0;
        int count = 0;
        while (!crawler.isEndOfWord && isSingleNode(crawler)) {
            index = getIndex(crawler);
            crawler = crawler.children[index];
            count++;
        }

        return count;
    }

    public static void main(String args[]) {
        Trie obj = new Trie();
        String[] words = {"geeksforgeeks", "geeks", "geek", "geezer"};
        obj.completeTrie(words);
        int index = obj.getLastSingleIndex();
        System.out.println(words[0].substring(0, index));
    }

}