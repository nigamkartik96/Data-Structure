/**
 * A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).
 *
 * Path Sum: Example 1
 *
 * How many possible unique paths are there?
 *
 * Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.
 *
 * Example :
 *
 * Input : A = 2, B = 2
 * Output : 2
 *
 * 2 possible routes : (0, 0) -> (0, 1) -> (1, 1)
 *               OR  : (0, 0) -> (1, 0) -> (1, 1)
 */
package maths;

public class GridUniquePath {
    int uniquePath(int A, int B) {
        int dp[][] = new int[A+1][B+1];

        for(int i = 0; i <= B; i++) dp[1][i] = 1;
        for(int i = 0; i <= A; i++) dp[i][1] = 1;

        for(int i = 2; i <= A; i ++) {
            for (int j = 2; j <= B; j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }

        return dp[A][B];
    }

    public static void main(String args[]) {
        GridUniquePath obj = new GridUniquePath();
        System.out.println(obj.uniquePath(3, 3));
    }
}
