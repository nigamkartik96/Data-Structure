/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 * <p>
 * Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * <p>
 * Your program should return a list of strings, where each string represents a single line.
 * <p>
 * Example:
 * <p>
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * <p>
 * L: 16.
 * <p>
 * Return the formatted lines as:
 * <p>
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 */
package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JustifiedText {
    public static void main(String args[]) {
        JustifiedText obj = new JustifiedText();
        List<String> lines = Arrays.asList("glu", "muskzjyen", "ahxkp", "t", "djmgzzyh", "jzudvh", "raji", "vmipiz", "sg", "rv", "mekoexzfmq", "fsrihvdnt", "yvnppem", "gidia", "fxjlzekp", "uvdaj", "ua", "pzagn", "bjffryz", "nkdd", "osrownxj", "fvluvpdj", "kkrpr", "khp", "eef", "aogrl", "gqfwfnaen", "qhujt", "vabjsmj", "ji", "f", "opihimudj", "awi", "jyjlyfavbg", "tqxupaaknt", "dvqxay", "ny", "ezxsvmqk", "ncsckq", "nzlce", "cxzdirg", "dnmaxql", "bhrgyuyc", "qtqt", "yka", "wkjriv", "xyfoxfcqzb", "fttsfs", "m");
        System.out.println(obj.fullJustify(lines, 144));
    }

    public static ArrayList<String> fullJustify(List<String> words, int L) {
        ArrayList<String> lines = new ArrayList<>();
        int index = 0;
        while (index < words.size()) {
            int last = index + 1;
            int count = words.get(index).length();
            while (last < words.size()) {
                if (count + words.get(last).length() + 1 > L) break;
                count += words.get(last).length() + 1;
                last++;
            }

            StringBuilder line = new StringBuilder();
            int diff = last - index - 1;
            if (last == words.size() || diff == 0) {
                for (int i = index; i < last; i++) {
                    line.append(words.get(i)).append(" ");
                }
                line.deleteCharAt(line.length() - 1);
                for (int i = line.length(); i < L; i++) {
                    line.append(" ");
                }

            } else {
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                for (int i = index; i < last; i++) {
                    line.append(words.get(i));
                    for (int j = 0; j <= spaces + (i - index < r ? 1 : 0); j++) {
                        line.append(" ");
                    }
                }
            }
            String b = line.toString();
            if (line.length() > L) {
                b = b.trim();
            }
            index = last;
            lines.add(b);
        }
        return lines;
    }
}
