package subarray;

public class Method2 {
    public void printSubArray(int arr[], int sum) {
        int currSum = arr[0], start = 0, n = arr.length, flag = 0;

        for (int i = 1; i <= n; i++) {
            while (currSum > sum && start < i - 1) {
                currSum = currSum - arr[start];
                start++;
            }

            if (currSum == sum) {
                System.out.println((start + 1) + " " + i);
                flag = 1;
                break;
            }

            if (i < n) currSum += arr[i];
        }

        if (flag == 0) System.out.println(-1);
    }

    public static void main(String args[]) {
        Method2 method2 = new Method2();
        int arr[] = {1, 2, 3, 7, 5};
        method2.printSubArray(arr, 12);
    }
}
