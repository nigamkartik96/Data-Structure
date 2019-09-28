/**
 * There are two parallel roads, each containing N and M buckets, respectively. Each bucket may contain some balls. The buckets on both roads are kept in such a way that they are sorted according to the number of balls in them. Geek starts from the end of the road which has the bucket with a lower number of balls(i.e. if buckets are sorted in increasing order, then geek will start from the left side of the road).
 * The geek can change the road only at the point of intersection(which means, buckets with the same number of balls on two roads). Now you need to help Geek to collect the maximum number of balls.
 *
 * Input:
 * The first line of input contains T denoting the number of test cases. The first line of each test case contains two integers N and M, denoting the number of buckets on road1 and road2 respectively. 2nd line of each test case contains N integers, number of balls in buckets on the first road. 3rd line of each test case contains M integers, number of balls in buckets on the second road.
 *
 * Output:
 * For each test case output a single line containing the maximum possible balls that Geek can collect.
 *
 * Constraints:
 * 1<= T <= 1000
 * 1<= N <= 10^3
 * 1<= M <=10^3
 * 0<= A[i],B[i]<=10^6
 *
 * Example:
 * Input:
 * 1
 * 5 5
 * 1 4 5 6 8
 * 2 3 4 6 9
 *
 * Output:
 * 29
 *
 * Explanation:
 *
 * The path with maximum sum is (2,3,4)[5,6](9). Integers in [] are the buckets of first road and in () are the buckets of second road. So, max balls geek can collect is 29.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CollectBalls {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        StringBuilder s = new StringBuilder();
        while (testCases-- != 0) {
            String s1[] = br.readLine().split(" "), s2[] = br.readLine().split(" "), s3[] = br.readLine().split(" ");
            int n = Integer.parseInt(s1[0]), m = Integer.parseInt(s1[1]);
            int[] a = new int[n], b = new int[m];
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s2[i]);
            for (int i = 0; i < m; i++) b[i] = Integer.parseInt(s3[i]);
            System.out.println(getCount(a, b, n, m));
        }
    }

    public static long getCount(int[] a, int[] b, int n, int m) {
        int i = 0, j = 0;
        long first = 0l, second = 0l;

        while (i < n && j < m) {
            if (a[i] < b[j]) {
                first += a[i];
                i++;
            } else if (a[i] > b[j]) {
                second += b[j];
                j++;
            } else {
                first += a[i];
                second += b[j];

                if (first > second) second = first;
                else first = second;

                i++;
                j++;
            }
        }

        if (i > 0 && j > 0 && a[i - 1] == b[j - 1]) {
            if (first > second) second = first;
            else first = second;
        }

        while (i < n) first += a[i++];
        while (j < m) second += b[j++];

        return second > first ? second : first;
    }
}
