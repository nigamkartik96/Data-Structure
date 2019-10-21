/**
 * Given two strings S and T, find count of distinct occurrences of T in S as a sub-sequence. Your task is to complete the function subsequenceCount which takes two strings as argument S and T and returns the count of the sub-sequences.
 *
 * Input:
 * The first line of input contains an integer t denoting the no of test cases . Then t test cases follow. The first line of each test case contains 2 strings S and T.
 *
 * Output:
 * For each test case in a new line print the count of distinct occurrences of T in S as a sub-sequence.
 *
 * Constraints:
 * 1<=t<=100
 * 1<=length of (S,T)<=100
 *
 * Example(To be used only for expected output):
 * Input
 * 2
 * banana ban
 * geeksforgeeks ge
 *
 * Output
 * 3
 * 6
 *
 * Explanation:
 * (i) For first test case  S = banana, T = ban there are 3 sub-sequences which are [ban], [ba n], [b an].
 * (ii) For second test case S = geeksforgeeks, T=ge there are 6 sub-sequences which are  [ge], [ ge], [g e], [g e] [g e] and [ g e].
 */
public class DistinctOccurrences {
    int subsequenceCount(String S, String T) {
        int m = T.length();
        int n = S.length();

        if (m > n)
            return 0;

        int mat[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            mat[i][0] = 0;

        for (int j = 0; j <= n; j++)
            mat[0][j] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (T.charAt(i - 1) != S.charAt(j - 1))
                    mat[i][j] = mat[i][j - 1];
                else
                    mat[i][j] = mat[i][j - 1] + mat[i - 1][j - 1];
            }
        }

        return mat[m][n];
    }

    public static void main(String args[]) {
        DistinctOccurrences obj = new DistinctOccurrences();
        System.out.println(obj.subsequenceCount("geeksforgeeks", "ge"));
    }
}
