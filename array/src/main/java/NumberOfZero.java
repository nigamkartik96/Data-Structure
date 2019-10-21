/**
 * Given an array of size N consisting of only 0's and 1's ,which is sorted in such a manner that all the 1's are placed first and then they are followed by all the 0's. You have to find  the count of all the 0's.
 *
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
 * The first line of each test case contains an integer N, where N is the size of the array A[ ].
 * The second line of each test case contains N space separated integers of all 1's follwed by all the 0's, denoting elements of the array A[ ].
 *
 *
 * Output:
 * Print out the number of 0's in the array.
 *
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 30
 * 0 <= A[i] <= 1
 *
 *
 * Example :
 *
 * Input:
 * 3
 * 12
 * 1 1 1 1 1 1 1 1 1 0 0 0
 * 5
 * 0 0 0 0 0
 * 6
 * 1 1 1 1 1 1
 *
 *
 * Output:
 * 3
 * 5
 * 0
 *
 *
 * Expected Complexity:
 *
 * O(logN)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfZero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- != 0) {
            int n = Integer.parseInt(br.readLine());
            String s[] = br.readLine().split("\\s");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            int index = getIndex(arr, n);
            int number = index == -1 ? 0 : n - index;

            System.out.println(number);
        }
    }

    private static int getIndex(int[] arr, int n) {
        int l = 0, r = n - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (arr[mid] == 1) {
                l = mid + 1;
            } else {
                if (mid == 0 && arr[mid] == 0) return mid;
                if (arr[mid - 1] == 1 && arr[mid] == 0) return mid;

                r = mid - 1;
            }
        }
        return -1;
    }
}
