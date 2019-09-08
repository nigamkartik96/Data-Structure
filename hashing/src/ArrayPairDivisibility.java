/**
 * Given an array of integers and a number k, write a function that returns true if given array can be divided into pairs such that sum of every pair is divisible by k.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The T test cases follow. Each test case contains an integer n denoting the size of the array. The next line contains the n space separated integers forming the array. The last line contains the value of k.
 *
 * Output:
 * Print "True" (without quotes) if given array can be divided into pairs such that sum of every pair is divisible by k or else "False" (without quotes).
 *
 * Constraints:
 * 1<=T<=100
 * 2<=n<=10^5
 * 1<=a[i]<=10^5
 * 1<=k<=10^5
 *
 * Example:
 * Input:
 * 2
 * 4
 * 9 7 5 3
 * 6
 * 4
 * 91 74 66 48
 * 10
 *
 * Output:
 * True
 * False
 */

import java.util.Scanner;

public class ArrayPairDivisibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            int n = sc.nextInt();
            int sum = 0;
            for (int i = 0; i < n; i++) sum += sc.nextInt();
            int divisor = sc.nextInt();
            String print = "False";
            if (n % 2 == 0 && sum % divisor == 0)
                print = "True";
            System.out.println(print);
        }
    }
}
