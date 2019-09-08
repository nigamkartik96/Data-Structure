/**
 * You are given an array A of size N. You need to print the total count of sub-arrays having their sum equal to 0
 *
 * Input:
 * First line of the input contains an integer T denoting the number of test cases. Each test case consists of two lines. First line of each test case contains an Integer N denoting the size of the array, and the second line contains N space separated integers.
 *
 * Output:
 * For each test case, in a new line, print the total number of subarrays whose sum is equal to 0.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1<= N <= 107
 * -1010 <= Ai <= 1010
 *
 * Example:
 * Input:
 * 2
 * 6
 * 0 0 5 5 0 0
 * 10
 * 6  -1 -3 4 -2 2 4 6 -12 -7
 *
 * Output:
 * 6
 * 4
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SubArrayWithZero {
    static class Pair {
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(getCount(arr, n));
        }
    }

    public static int getCount(int arr[], int n) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Pair> pairs = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) {
                pairs.add(new Pair(0, i));
            }
            ArrayList<Integer> al = new ArrayList<>();
            if (map.containsKey(sum)) {
                al = map.get(sum);
                for (int j = 0; j < al.size(); j++) {
                    pairs.add(new Pair(al.get(j) + 1, i));
                }
            }
            al.add(i);
            map.put(sum, al);
        }
        return pairs.size();
    }
}
