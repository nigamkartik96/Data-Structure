/**
 * Given an array of integers, and an integer  ‘K’ , find the count of pairs of elements in the array whose sum is equal to 'K'.
 *
 * Input:
 * First line of the input contains an integer T, denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains 2 space separated integers N and K denoting the size of array and the sum respectively. Second line of each test case contains N space separated integers denoting the elements of the array.
 *
 * Output:
 * Print the count of pairs of elements in the array whose sum is equal to the K.
 *
 * Constraints:
 * 1<=T<=50
 * 1<=N<=50
 * 1<=K<=50
 * 1<=A[i]<=100
 *
 * Example:
 * Input
 * 2
 * 4 6
 * 1  5  7 1
 * 4 2
 * 1 1 1 1
 * Output
 * 2
 * 6
 */

import java.util.HashMap;

public class CountSum {
    static int arr[] = new int[]{1, 1, 1, 1};

    static int getPairsCount(int n, int sum) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        int twice_count = 0;
        for (int i = 0; i < n; i++) {
            if (hm.get(sum - arr[i]) != null)
                twice_count += hm.get(sum - arr[i]);
            if (sum - arr[i] == arr[i])
                twice_count--;
        }
        return twice_count / 2;
    }

    public static void main(String[] args) {
        int sum = 2;
        System.out.println("Count of pairs is " +
                getPairsCount(arr.length, sum));

    }
}
