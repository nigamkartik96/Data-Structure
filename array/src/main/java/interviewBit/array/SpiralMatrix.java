/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Given n = 3,
 *
 * You should return the following matrix:
 *
 * [
 *   [ 1, 2, 3 ],
 *   [ 8, 9, 4 ],
 *   [ 7, 6, 5 ]
 * ]
 */
package interviewBit.array;

import java.util.ArrayList;

public class SpiralMatrix {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int k = 0, l = 0, n = A, m = A, i, val = 1;
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (i = 0; i < A; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < A; j++) {
                list.add(0);
            }
            matrix.add(list);
        }
        while (k < m && l < n) {
            for (i = l; i < n; i++) {
                matrix.get(k).set(i, val++);
            }
            k++;

            for (i = k; i < m; i++) {
                matrix.get(i).set(n - 1, val++);
            }
            n--;

            if (k < m) {
                for (i = n - 1; i >= l; i--) matrix.get(m - 1).set(i, val++);
                m--;
            }

            if (l < n) {
                for (i = m - 1; i >= k; i--) matrix.get(i).set(l, val++);
                l++;
            }
        }

        return matrix;
    }

    public static void main(String args[]) {
        SpiralMatrix obj = new SpiralMatrix();
        System.out.println(obj.generateMatrix(4));
    }
}
