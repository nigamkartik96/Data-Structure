package maths;

public class ReverseInteger {
    public int reverse(int A) {
        boolean flag = false;
        if(A < 0) { A *= -1; flag = true;}

        int duplicate = A, count = 0;
        long val = 0;
        while (duplicate != 0) {
            val = val * 10 + (duplicate % 10);
            duplicate /= 10;
        }
        if (val >= Integer.MAX_VALUE || val <= Integer.MIN_VALUE) return 0;
        return (int) (flag ? val * -1: val);
    }

    public static void main(String args[]) {
        ReverseInteger obj = new ReverseInteger();
        System.out.println(obj.reverse(123));
    }
}
