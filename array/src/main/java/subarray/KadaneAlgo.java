package subarray;

import java.util.Scanner;

public class KadaneAlgo {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        StringBuilder s = new StringBuilder("");
        while(testCases-- != 0) {
            int n = sc.nextInt(), a[] = new int[n];
            a[0] = sc.nextInt();
            int currentMax = a[0], globalMax = a[0];
            for (int i = 1; i < n; i++) {
                a[i] = sc.nextInt();
                currentMax = Math.max(a[i], (a[i] + currentMax));

                if (currentMax >= globalMax) globalMax = currentMax;
            }
            s.append(globalMax + "\n");
        }

        System.out.println(s);
    }
}
