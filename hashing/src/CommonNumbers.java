/**
 * Given three increasingly sorted arrays A, B, C of sizes N1, N2, and N3 respectively, you need to print all common elements in these arrays.
 *
 * Note: Please avoid printing the same common element more than once.
 *
 * Input:
 * First line contains a single integer T denoting the total number of test cases. T testcases follow. Each testcase contains four lines of input. First line consists of 3 integers N1, N2 and N3, denoting the sizes of arrays A, B, C respectively. The second line contains N1 elements of A array. The third lines contains N2 elements of B array. The fourth lines contains N3 elements of C array.
 *
 * Output:
 * For each testcase, print the common elements of array. If not possible then print -1.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N1, N2, N3 <= 107
 * 1 <= Ai, Bi, Ci <= 1018
 *
 * Example:
 * Input:
 * 1
 * 6 5 8
 * 1 5 10 20 40 80
 * 6 7 20 80 100
 * 3 4 15 20 30 70 80 120
 * Output:
 * 20 80
 *
 * Explanation:
 * Testcase1:  20 and 80 are the only common elements
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class CommonNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        StringBuilder s = new StringBuilder();
        while (testCases-- != 0) {
            String s1[] = br.readLine().split(" "), s2[] = br.readLine().split(" "),
                    s3[] = br.readLine().split(" "), s4[] = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]), y = Integer.parseInt(s1[1]),
                    z = Integer.parseInt(s1[2]);

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < x; i++) {
                int value = Integer.parseInt(s2[i]);
                map.put(value, 1);
            }

            for (int i = 0; i < y; i++) {
                int value = Integer.parseInt(s3[i]);
                if (map.containsKey(value) && map.get(value) == 1) map.put(value, 2);
            }

            for (int i = 0; i < z; i++) {
                int value = Integer.parseInt(s4[i]);
                if (map.containsKey(value) && map.get(value) == 2) map.put(value, 3);
            }
            boolean flag = false;
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                int value = e.getValue(), key = e.getKey();
                if (value == 3) {
                    flag = true;
                    s.append(key + " ");
                }
            }

            if (!flag) s.append(-1);

            if (testCases != 0) s.append("\n");
        }

        System.out.println(s.toString());
    }
}
