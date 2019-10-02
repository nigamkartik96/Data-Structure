/**
 * You are given an array A of size N. Your task is to find the minimum number of operations needed to convert the given array to 'Palindromic Array'.
 *
 * Palindromic Array:
 * [23,15,23] is a ‘Palindromic Array’ but [2,0,1] is not.
 *
 * The only allowed operation is that you can merge two adjacent elements in the array and replace them with their sum.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases.
 * The first line of each test case is N, where N is the size of array.
 * The second line of each test case contains N space separated integers which is the input for the array.
 *
 * Output:
 * Output the minimum number of operations required to make the given array a palindromic array.
 *
 * Constraints:
 * 1<=T<=100
 * 1<=N<=100
 *
 * Example:
 * Input:
 * 2
 * 5
 * 3 2 3 3 5
 * 4
 * 5 3 3 4
 * Output:
 * 1
 * 3
 *
 * Explanation:
 * For Test Case 1: [3 2 3 3 5] after merging the 1st two elements 3 and 2, we get the array as [5 3 3 5] which is a palindrome, hence only 1 operation is needed.
 */

import java.util.Scanner;

public class PalindromeArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(getOps(arr, n));
        }
    }

    private static int getOps(int[] arr, int n) {
        int ops = 0, i = 0, j = n - 1;
        while (i <= j) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
            } else if (arr[i] > arr[j]) {
                int temp = arr[j];
                j--;
                arr[j] += temp;
                ops++;
            } else {
                int temp = arr[i];
                i++;
                arr[i] += temp;
                ops++;
            }
        }
        return ops;
    }
}
