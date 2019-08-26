import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.
 * <p>
 * Input:
 * The first line contains an integer 'T' denoting the total number of test cases. Then T testcases follow. Each testcases contains two lines of input. The first line denotes the size of the array N. The second lines contains the elements of the array A separated by spaces.
 * <p>
 * Output:
 * For each testcase, print the sorted array.
 * <p>
 * Constraints:
 * 1 <= T <= 500
 * 1 <= N <= 106
 * 0 <= Ai <= 2
 * <p>
 * Example:
 * Input :
 * 2
 * 5
 * 0 2 1 2 0
 * 3
 * 0 1 0
 * <p>
 * Output:
 * 0 0 1 2 2
 * 0 0 1
 * <p>
 * Explanation:
 * Testcase 1: After segragating the 0s, 1s and 2s, we have 0 0 1 2 2 which shown in the output.
 */
public class DutchFlag {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- != 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().trim().split(" ");

            sort(arr, n);
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < n; i++) str.append(arr[i] + " ");
            System.out.println(str.toString());
        }
    }

    public static void sort(String arr[], int n) {
        if (n == 1) {
            return;
        }
        int pointer0 = 0, pointer2 = n - 1;
        int i = 0;
        while (i <= pointer2) {
            switch (arr[i]) {
                case "0":
                    swap(arr, i, pointer0);
                    pointer0++;
                    i++;
                    break;
                case "1":
                    i++;
                    break;
                case "2":
                    swap(arr, i, pointer2);
                    pointer2--;
            }
        }
    }

    public static void swap(String arr[], int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
