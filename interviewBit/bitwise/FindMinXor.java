/**
 * Given an array of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.
 *
 * Examples :
 * Input
 * 0 2 5 7
 * Output
 * 2 (0 XOR 2)
 * Input
 * 0 4 7 9
 * Output
 * 3 (4 XOR 7)
 *
 * Constraints:
 * 2 <= N <= 100 000
 * 0 <= A[i] <= 1 000 000 000
 */
package bitwise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMinXor {
    public int findMinXor(List<Integer> A) {
        Collections.sort(A);
        int minXor = Integer.MAX_VALUE, value = 0;
        for (int i = 0; i < A.size() - 1; i++) {
            value = A.get(i) ^ A.get(i + 1);
            minXor = Math.min(value, minXor);
        }

        return minXor;
    }

    public static void main(String args[]) {
        FindMinXor obj = new FindMinXor();
        List<Integer> list = Arrays.asList(0, 2, 5, 7);
        System.out.println(obj.findMinXor(list));
    }
}
