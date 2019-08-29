/**
 * Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m. The task is to merge the two sorted arrays into one sorted array (in non-decreasing order).
 *
 * Note: Expected time complexity is O((n+m) log(n+m)). DO NOT use extra space.  We need to modify existing arrays as following.
 *
 * Input: arr1[] = {10};
 *        arr2[] = {2, 3};
 * Output: arr1[] = {2}
 *         arr2[] = {3, 10}
 *
 * Input: arr1[] = {1, 5, 9, 10, 15, 20};
 *        arr2[] = {2, 3, 8, 13};
 * Output: arr1[] = {1, 2, 3, 5, 8, 9}
 *         arr2[] = {10, 13, 15, 20}
 * Input:
 * First line contains an integer T, denoting the number of test cases. First line of each test case contains two space separated integers X and Y, denoting the size of the two sorted arrays. Second line of each test case contains X space separated integers, denoting the first sorted array P. Third line of each test case contains Y space separated integers, denoting the second array Q.
 *
 * Output:
 * For each test case, print (X + Y) space separated integer representing the merged array.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= X, Y <= 5*104
 * 0 <= arr1i, arr2i <= 109
 *
 * Example:
 * Input:
 * 2
 * 4 5
 * 1 3 5 7
 * 0 2 6 8 9
 * 2 3
 * 10 12
 * 5 18 20
 *
 * Output:
 * 0 1 2 3 5 6 7 8 9
 * 5 10 12 18 20
 *
 * Explanation:
 * Testcase 1: After merging two non-decreasing arrays, we have, 0 1 2 3 5 6 7 8 9.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSortO1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        MergeSortO1 gfg = new MergeSortO1();
        while (testCases-- != 0) {
            gfg = new MergeSortO1();
            String s = br.readLine();
            int n = Integer.parseInt(s.split(" ")[0]), m = Integer.parseInt(s.split(" ")[1]);
            int a[] = new int[n], b[] = new int[m];
            s = br.readLine();
            String[] a1 = s.split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(a1[i]);
            s = br.readLine();
            a1 = s.split(" ");
            for (int i = 0; i < m; i++) b[i] = Integer.parseInt(a1[i]);

            gfg.sort(a, b, n, m);

            StringBuilder str = new StringBuilder();
            for (int i = 0; i < n; i++) str.append(a[i] + " ");
            for (int i = 0; i < m; i++) str.append(b[i] + " ");

            System.out.println(str.toString());
        }
    }

    public void sort(int[] arr1, int[] arr2, int n, int m) {
        int i, j, gap = n + m;
        for (gap = nextGap(gap); gap > 0;
             gap = nextGap(gap)) {
            for (i = 0; i + gap < n; i++)
                if (arr1[i] > arr1[i + gap]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }

            for (j = gap > n ? gap - n : 0;
                 i < n && j < m; i++, j++)
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }

            if (j < m) {
                for (j = 0; j + gap < m; j++)
                    if (arr2[j] > arr2[j + gap]) {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
            }
        }
    }

    public int nextGap(int gap) {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }
}
