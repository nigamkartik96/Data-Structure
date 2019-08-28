/**
 * array with equal number of 0's and 1's. The function maxLen takes 2 arguments. The first argument is the array A[] and second argument is the size 'N' of the array A[].
 *
 * Input:
 * The first line of the input is T denoting the number of test cases. Then T test cases follow . Each test case contains two lines. The first line of each test case is a number N denoting the size of the array and in the next line are N space separated values of A [].
 *
 * Output:
 * For each test case output in a new line the max length of the subarray.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 100
 * 0 <= A[] <= 1
 *
 * Example:
 * Input
 * 2
 * 4
 * 0 1 0 1
 * 5
 * 0 0 1 0 0
 *
 * Output
 * 4
 * 2
 */
public class Equal0And1 {
    int maxLen(int[] arr) {
        int sum = 0;
        int n = arr.length;
        int maxsize = -1, startindex = 0;

        for (int i = 0; i < n - 1; i++) {
            sum = (arr[i] == 0) ? -1 : 1;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] == 0)
                    sum += -1;
                else
                    sum += 1;

                if (sum == 0 && maxsize < j - i + 1) {
                    maxsize = j - i + 1;
                    startindex = i;
                }
            }
        }
        if (maxsize == -1)
            return 0;
        else
            return maxsize;
    }

    public static void main(String args[]) {
        Equal0And1 obj = new Equal0And1();
        int arr[] = {0, 1, 0, 1};
        System.out.println(obj.maxLen(arr));
    }
}
