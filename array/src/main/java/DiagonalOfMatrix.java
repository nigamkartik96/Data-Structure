/**
 * Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.
 *
 * For Example:
 * If the matrix is
 *
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * The output should Return the following :
 *
 * [
 *   [1],
 *   [2, 4],
 *   [3, 5, 7],
 *   [6, 8],
 *   [9]
 * ]
 * i.e print the elements of array diagonally.
 *
 * Note: The input array given is in single line and you have to output the answer in one line only.
 *
 *
 *
 * Input:
 *
 * The first line contains an integer T, depicting total number of test cases.
 * Then following T lines contains an integer N depicting the size of square matrix and next line followed by the value of array.
 *
 *
 * Output:
 *
 * Print the elements of matrix diagonally in separate line.
 *
 *
 * Constraints:
 *
 * 1 ≤ T ≤ 30
 * 1 ≤ N ≤ 20
 * 0 ≤ A[i][j] ≤ 9
 *
 *
 * Example:
 *
 * Input:
 * 2
 * 2
 * 1 2 3 4
 * 3
 * 1 2 3 4 5 6 7 8 9
 * Output:
 * 1 2 3 4
 * 1 2 4 3 5 7 6 8 9
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class DiagonalOfMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- != 0) {
            int n = Integer.parseInt(br.readLine());
            String s1[] = br.readLine().split(" ");
            int arr[][] = new int[n][n];
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(s1[k++]);
                }
            }

            printReverseDiagonals(arr, n);
            System.out.println();
        }
    }

    private static void printReverseDiagonals(int[][] arr, int n) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        int count = -1;
        for (int i = 0; i < n; i++) {
            count = i;
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> temp = map.getOrDefault(count, new ArrayList<>());
                temp.add(arr[i][j]);
                map.put(count, temp);
                count++;
            }
        }

        for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
            ArrayList<Integer> temp = e.getValue();
            for (int i : temp) {
                System.out.print(i + " ");
            }
        }
    }
}
