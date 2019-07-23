/**
 * Implement pow(x, n) % d.
 * <p>
 * In other words, given x, n and d,
 * <p>
 * find (xn % d)
 * <p>
 * Note that remainders on division cannot be negative.
 * In other words, make sure the answer you return is non negative.
 * <p>
 * Input : x = 2, n = 3, d = 3
 * Output : 2
 * <p>
 * 2^3 % 3 = 8 % 3 = 2.
 */
package binarysearch;

public class PowerFunction {
    public int pow(int x, int n, int d) {
        if (x == 0) return 0;
        if (n == 0) return 1 % d;
        int result = 1;
        x = x % d;
        while (n > 0) {
            if (n % 2 == 1) {
                result = (int) ((1L * x * result) % d);
            }

            x = (int) ((1L * x * x) % d);
            n = n / 2;
        }
        if (result < 0) result += d;
        return result;
    }

    public static void main(String args[]) {
        PowerFunction obj = new PowerFunction();
        System.out.println(obj.pow(2,3,3));
    }
}
