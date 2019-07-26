/**
 * Given an array ‘A’ of sorted integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 *
 *  Example: Input :
 *     A : [1 3 5]
 *     k : 4
 *  Output : YES as 5 - 1 = 4
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 * Try doing this in less than linear space complexity.
 */
package twoPointers;

import java.util.Arrays;
import java.util.List;

public class Diffick {
    public int diffPossible(List<Integer> A, int B) {
        for (int i = A.size() - 1; i > 0; i--) {
            int diff = A.get(i) - B;
            if (diff < A.get(0)) continue;
            if (A.subList(0, i).contains(diff)) return 1;
        }

        return 0;
    }

    public static void main(String args[]) {
        Diffick obj = new Diffick();
        System.out.println(obj.diffPossible(Arrays.asList(1, 2, 2, 4, 5), 0));
    }
}
