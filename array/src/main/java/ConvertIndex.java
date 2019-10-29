/**
 * Given an array of size n where all elements are distinct and in range from 0 to n-1, change contents of arr[] so that arr[i] = j is changed to arr[j] = i.
 * Examples:
 *
 * Example 1:
 * Input: arr[]  = {1, 3, 0, 2};
 * Output: arr[] = {2, 0, 3, 1};
 * Explanation for the above output.
 * Since arr[0] is 1, arr[1] is changed to 0
 * Since arr[1] is 3, arr[3] is changed to 1
 * Since arr[2] is 0, arr[0] is changed to 2
 * Since arr[3] is 2, arr[2] is changed to 3
 *
 * Example 2:
 * Input: arr[]  = {2, 0, 1, 4, 5, 3};
 * Output: arr[] = {1, 2, 0, 5, 3, 4};
 *
 * Example 3:
 * Input: arr[]  = {0, 1, 2, 3};
 * Output: arr[] = {0, 1, 2, 3};
 *
 * Example 4:
 * Input: arr[]  = {3, 2, 1, 0};
 * Output: arr[] = {3, 2, 1, 0};
 */

public class ConvertIndex {
    private void rearrange(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i]++;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) rearrangeUtil(arr, i);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = (-arr[i]) - 1;
        }
    }

    private void rearrangeUtil(int arr[], int i) {
        int val = -(i + 1);
        i = arr[i] - 1;
        while (arr[i] > 0) {
            int index = arr[i] - 1;
            arr[i] = val;
            val = -(i + 1);
            i = index;
        }
    }

    public static void main(String args[]) {
        ConvertIndex obj = new ConvertIndex();
        int arr[] = new int[]{2, 0, 1, 4, 5, 3};
        obj.rearrange(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
