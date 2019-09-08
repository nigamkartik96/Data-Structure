/**
 * Given an array A of size N, find all combination of four elements in the array whose sum is equal to a given value K. For example, if the given array is {10, 2, 3, 4, 5, 9, 7, 8} and K = 23, one of the quadruple is “3 5 7 8” (3 + 5 + 7 + 8 = 23).
 *
 * The output should contain only unique quadrples  For example, if input array is {1, 1, 1, 1, 1, 1} and K = 4, then output should be only one quadrple {1, 1, 1, 1}
 *
 *
 * Input:
 * The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two lines. The first line of input contains two integers N and K. Then in the next line are N space separated values of the array.
 *
 * Output:
 * For each test case in a new line print all the quadruples present in the array separated by space which sums up to value of K. Each quadruple is unique which are separated by a delimeter "$" and are in increasing order.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 100
 * -1000 <= K <= 1000
 * -100 <= A[] <= 100
 *
 * Example:
 * Input:
 * 2
 * 5 3
 * 0 0 2 1 1
 * 7 23
 * 10 2 3 4 5 7 8
 *
 * Output:
 * 0 0 1 2 $
 * 2 3 8 10 $2 4 7 10 $3 5 7 8 $
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class SumOfFour {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        StringBuilder s = new StringBuilder();
        while (testCases-- != 0) {
            String s1[] = br.readLine().split(" "), s2[] = br.readLine().split(" ");
            int n = Integer.parseInt(s1[0]), sum = Integer.parseInt(s1[1]);
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s2[i]);
            }

            LinkedHashSet<ArrayList<Integer>> list = new LinkedHashSet<>();
            getSubList(arr, list, sum, 0, new ArrayList<Integer>(), 0);
            if (list.size() != 0)
                for (ArrayList<Integer> al : list) {
                    Collections.sort(al);
                    for (int i = 0; i < al.size(); i++) {
                        s.append(al.get(i) + " ");
                    }
                    s.append("$");
                }
            else s.append(-1 + "");
            if (testCases != 0) s.append("\n");
        }
        System.out.println(s.toString());
    }

    public static void getSubList(int[] arr, HashSet<ArrayList<Integer>> list, int sum, int currSum, ArrayList<Integer> temp, int index) {
        if (temp.size() == 4) {
            if (sum == currSum) list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            temp.add(arr[i]);
            getSubList(arr, list, sum, currSum + arr[i], temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
