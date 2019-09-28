/**
 * Given an array consisting cost of toys. Given an integer K depicting the amount with you. Maximise the number of toys you can have with K amount.
 *
 * Input:
 *
 * The first line contains an integer T, depicting total number of test cases.
 * Then following T lines contains an integer N depicting the number of toys and an integer K depicting the value of K.
 * Next line is followed by the cost of toys.
 *
 *
 * Output:
 *
 * Print the maximum toys in separate line.
 *
 *
 * Constraints:
 *
 * 1 ≤ T ≤ 30
 * 1 ≤ N ≤ 1000
 * 1 ≤ K ≤ 10000
 * 1 ≤ A[i] ≤ 10000
 *
 *
 * Example:
 *
 * Input
 * 1
 * 7 50
 * 1 12 5 111 200 1000 10
 * Output
 * 4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximizeToys {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- != 0) {
            String s1[] = br.readLine().split(" "), s2[] = br.readLine().split(" ");
            int n = Integer.parseInt(s1[0]), amount = Integer.parseInt(s1[1]);
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s2[i]);
            }
            Arrays.sort(arr);
            System.out.println(getMaxPrice(arr, n, amount));
        }
    }

    private static int getMaxPrice(int[] arr, int n, int amount) {
        int i = 0, count = 0;
        while (amount >= arr[i]) {
            count++;
            amount -= arr[i];
            i++;
        }
        return count;
    }
}
