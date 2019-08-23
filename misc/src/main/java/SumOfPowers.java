/**
 * Given two numbers X and N, find out the total number of ways X can be expressed as sum of Nth power of unique natural numbers.
 *
 *
 *
 * Examples:
 *
 * Input  : X = 10, N = 2
 * Output : 1
 * Explanation: 10 = 12 + 32,
 * Hence total 1 possibility
 *
 * Input  : X = 100, N = 2
 * Output : 3
 * Explanation: 100 = 102
 *              OR 62 + 82
 *              OR 12 + 32 + 42 + 52 + 72
 * Hence total 3 possibilities
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains a single line containing two space seperated integers denoting the values of X and N respectively.
 *
 * Output:
 * For each test case output a new line containing a single integer denoting the total number of ways X can be expressed as sum of Nth power of unique natural numbers.
 *
 * Constraints:
 * 1<=T<=100
 * 1<=X<=103
 * 1<=N<=5
 *
 * Example:
 * Input:
 * 2
 * 10 2
 * 100 2
 *
 * Output:
 * 1
 * 3
 */
public class SumOfPowers {
    static int checkRecursive(int x, int n, int curr_num, int curr_sum) {
        int results = 0;
        int p = (int) Math.pow(curr_num, n);
        while (p + curr_sum < x) {
            results += checkRecursive(x, n, curr_num + 1, p + curr_sum);
            curr_num++;
            p = (int) Math.pow(curr_num, n);
        }
        if (p + curr_sum == x)
            results++;
        return results;
    }

    public static void main(String[] args) {
        int x = 10, n = 2;
        System.out.println(checkRecursive(x, n, 1, 0));
    }

}
