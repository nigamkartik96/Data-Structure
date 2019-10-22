/**
 * Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. For simplicity, assume that all bars have same width and the width is 1 unit.
 * <p>
 * Input:
 * The first line contains an integer 'T' denoting the total number of test cases. T test-cases follow. In each test cases, the first line contains an integer 'N' denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array. The elements of the array represents the height of the bars.
 * <p>
 * Output:
 * For each test-case, in a separate line, the maximum rectangular area possible from the contiguous bars.
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 106
 * 1 <= A[i] <= 1018
 * <p>
 * Example:
 * Input:
 * 2
 * 7
 * 6 2 5 4 5 1 6
 * 4
 * 6 3 4 2
 * Output:
 * 12
 * 9
 */

import java.util.Scanner;
import java.util.Stack;

public class AreaHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            int n = sc.nextInt(), arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(getMaxArea(arr, n));
        }
    }

    private static int getMaxArea(int[] hist, int n) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        int top;
        int areaWithTop;

        int i = 0;
        while (i < n) {
            if (stack.empty() || hist[stack.peek()] <= hist[i])
                stack.push(i++);
            else {
                top = stack.pop();
                areaWithTop = hist[top] * (stack.empty() ? i : i - stack.peek() - 1);
                if (maxArea < areaWithTop) {
                    maxArea = areaWithTop;
                }
            }
        }

        while (!stack.empty()) {
            top = stack.pop();
            areaWithTop = hist[top] * (stack.empty() ? i : i - stack.peek() - 1);
            if (maxArea < areaWithTop) {
                maxArea = areaWithTop;
            }
        }
        return maxArea;
    }
}
