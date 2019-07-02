package subarray;

import java.util.Scanner;

public class Method1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            int n = sc.nextInt(), sum = sc.nextInt(), flag = 0;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();

            for (int i = 0; i < n; i++) {
                int testSum = 0, j;
                for (j = i; j < n; j++) {
                    testSum += a[j];
                    if (testSum >= sum) {
                        break;
                    }
                }
                if (testSum == sum) {
                    System.out.println((i + 1) + " " + (j + 1));
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) System.out.println(-1);
        }
    }

}
