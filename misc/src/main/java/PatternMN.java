import java.util.PriorityQueue;
import java.util.Stack;

public class PatternMN {

    PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

    int findPossibleSmallestNumberMatchingPattern(String pattern) {
        if (validatePattern(pattern))
            return -1;
        return Integer.parseInt(processString(pattern));

    }


    private boolean validatePattern(String pattern) {
        return (pattern.equals("") || pattern == "" || pattern == " " || pattern == null
                || getMNCount(pattern) != pattern.length());
    }

    private int getMNCount(String pattern) {
        int mCount = 0, nCount = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'M') {
                mCount++;
            }
            if (pattern.charAt(i) == 'N') {
                nCount++;
            }
        }
        return nCount + mCount;
    }
    public static void main(String args[]) {
        PatternMN obj = new PatternMN();
        System.out.println(obj.findPossibleSmallestNumberMatchingPattern("MNMN"));

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(2);
        queue.add(1);
        queue.add(3);
        queue.add(-1);
        System.out.println(queue.poll());
    }

    private String processString(String input) {
        String res = "";
        int len = input.length();
        for (int k = 1; k <= len + 1; k++)
            heap.add(k);
        int mCount;
        for (int i = 0; i < len; i++) {
            if (input.charAt(i) == 'M') {
                mCount = getConsecutiveCount(input, i, 'M');
                res += getElement(mCount + 1);
            } else {
                res += getElement(1);
            }

        }
        return res + heap.poll();
    }

    public int getConsecutiveCount(String input, int index, char ch) {
        int c = 0;
        for (int i = index; i < input.length(); i++) {
            if (input.charAt(i) == ch) {
                c++;
            } else {
                break;
            }
        }
        Stack<Integer> stack = new Stack<Integer>();
        return c;

    }

    private String getElement(int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int tmp = 0, c = 0;

        while (k-- > 0) {
            tmp = heap.poll();
            c++;
            if (k > 0) {
                pq.add(tmp);
            } else {
                break;
            }
        }
        heap.addAll(pq);
        return tmp + "";
    }
}
