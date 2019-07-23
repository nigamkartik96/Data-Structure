/**
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x.
 * <p>
 * If x is not a perfect square, return floor(sqrt(x))
 * <p>
 * Example :
 * <p>
 * Input : 11
 * Output : 3
 * DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
 */
package binarysearch;

public class SquareRoot {
    public int sqrt(int a) {
        if (a <= 0) return 0;
        if (a > 0 && a <= 2) return 1;
        long start = 0, end = a, mid = (long) Math.floor((start + end) / 2);
        while (start < end) {
            if (mid * mid == a) return (int) mid;
            if (mid * mid > a) {
                end = mid - 1;
                mid = (long) Math.floor((start + end) / 2);
            } else {
                start = mid + 1;
                mid = (long) Math.floor((start + end) / 2);
            }
        }
        if (mid * mid > a) return (int) mid - 1;
        return (int) mid;
    }

    public static void main(String args[]) {
        SquareRoot obj = new SquareRoot();
        System.out.println(obj.sqrt(11));
    }
}
