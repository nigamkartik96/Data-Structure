/**
 * Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.
 *
 * Expected Time Complexity: O(n)
 *
 * Input:
 * The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case consists of three lines. First line of each testcase contains an integer N denoting size of the array. Second line contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.
 *
 * Output:
 * Corresponding to each test case, print the kth smallest element in a new line.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 105
 * 1 <= arr[i] <= 105
 * 1 <= K <= N
 *
 * Example:
 * Input:
 * 2
 * 6
 * 7 10 4 3 20 15
 * 3
 * 5
 * 7 10 4 20 15
 * 4
 *
 * Output:
 * 7
 * 15
 *
 * Explanation:
 * Testcase 1: 3rd smallest element in the given array is 7.
 */

import java.util.Scanner;

public class KthSmallestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- != 0) {
            int n = sc.nextInt(), k;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            k = sc.nextInt();

            System.out.println(kthSmallest(arr, 0, n - 1, k));
        }
    }

    static int kthSmallest(int arr[], int l, int r, int k) {
        if (k > 0 && k <= r - l + 1) {
            int pos = randomPartition(arr, l, r);

            if (pos - l == k - 1)
                return arr[pos];

            if (pos - l > k - 1)
                return kthSmallest(arr, l, pos - 1, k);

            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }

        return Integer.MAX_VALUE;
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int arr[], int l, int r) {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    static int randomPartition(int arr[], int l, int r) {
        int n = r - l + 1;
        int pivot = (int) (Math.random()) * (n - 1);
        swap(arr, l + pivot, r);
        return partition(arr, l, r);
    }
}
