/**
 * Given an array A of size N having distinct elements, the task is to find the next greater element for each element of the array in order of their appearance in the array. If no such element exists, output -1
 *
 * Input:
 * The first line of input contains a single integer T denoting the number of test cases.Then T test cases follow. Each test case consists of two lines. The first line contains an integer N denoting the size of the array. The Second line of each test case contains N space separated positive integers denoting the values/elements in the array A.
 *
 * Output:
 * For each test case, print in a new line, the next greater element for each array element separated by space in order.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 107
 * 1 <= Ai <= 1018
 * Example:
 * Input
 * 2
 * 4
 * 1 3 2 4
 * 4
 * 4 3 2 1
 * Output
 * 3 4 4 -1
 * -1 -1 -1 -1
 *
 * Explanation:
 * Testcase1: In the array, the next larger element to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? since it doesn't exist hence -1.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class NextLargest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        StringBuilder str = new StringBuilder();
        while (testCases-- != 0) {
            int n = Integer.parseInt(br.readLine());
            String input[] = br.readLine().split(" ");
            Long arr[] = new Long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(input[i]);
            }

            Long a[] = getNextLargest(arr);

            for (int i = 0; i < n; i++) {
                str.append(a[i] + " ");
            }
            if (testCases != 0)
                str.append("\n");
        }

        System.out.println(str.toString());
    }

    public static Long[] getNextLargest(Long arr[]) {
        Stack<Long> stack = new Stack<>();
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                map.put(stack.pop(), arr[i]);
            }
            stack.push(arr[i]);
        }

        while (!stack.isEmpty()) map.put(stack.pop(), new Long(-1));

        Long result[] = new Long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = map.get(arr[i]);
        }

        return result;
    }
}
