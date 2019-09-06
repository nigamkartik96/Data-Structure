/**
 * Given two arrays A1[] and A2[] of size N and M respectively. The task is to sort A1 in such a way that the relative order among the elements will be same as those in A2. For the elements not present in A2, append them at last in sorted order. It is also given that the number of elements in A2[] are smaller than or equal to number of elements in A1[] and A2[] has all distinct elements.
 *
 * Note: Expected time complexity is O(N log(N)).
 *
 * Input:
 * First line of input contains number of testcases. For each testcase, first line of input contains length of arrays N and M and next two line contains N and M elements respectively.
 *
 * Output:
 * Print the relatively sorted array.
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N,M  ≤ 106
 * 1 ≤ A1[], A2[] <= 106
 *
 * Example:
 * Input:
 * 1
 * 11 4
 * 2 1 2 5 7 1 9 3 6 8 8
 * 2 1 8 3
 *
 * Output:
 * 2 2 1 1 8 8 3 5 6 7 9
 *
 * Explanation:
 * Testcase 1: Array elements of A1[] are sorted according to A1[].
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class RelativeSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        StringBuilder s = new StringBuilder();

        while (testCases-- != 0) {
            String s1[] = br.readLine().split(" "), s2[] = br.readLine().split(" "),
                    s3[] = br.readLine().split(" ");

            int n = Integer.parseInt(s1[0]), m = Integer.parseInt(s1[1]);
            int a1[] = new int[n], a2[] = new int[m];
            for (int i = 0; i < n; i++) {
                a1[i] = Integer.parseInt(s2[i]);
            }
            for (int i = 0; i < m; i++) {
                a2[i] = Integer.parseInt(s3[i]);
            }

            getSortedArray(a1, a2, n, m);
            for (int i = 0; i < n; i++) {
                s.append(a1[i] + " ");
            }
            if (testCases != 0)
                s.append("\n");
        }

        System.out.println(s.toString());
    }

    public static void getSortedArray(int[] a1, int[] a2, int n, int m) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(a1[i])) {
                map.put(a1[i], map.get(a1[i]) + 1);
            } else {
                map.put(a1[i], 1);
            }
        }
        int k = 0;

        for (int i = 0; i < m; i++) {
            if (map.containsKey(a2[i])) {
                int val = map.get(a2[i]);
                while (val-- >= 1) {
                    a1[k++] = a2[i];
                }
                map.remove(a2[i]);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            while (val-- != 0) {
                a1[k++] = entry.getKey();
            }
        }

    }
}
