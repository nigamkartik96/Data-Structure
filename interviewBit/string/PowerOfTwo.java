package string;

import java.math.BigInteger;

public class PowerOfTwo {
    public int power(String A) {
        if(A.equals("1")) return 0;
        BigInteger number = new BigInteger(A);
        while (!number.equals(new BigInteger("1"))) {
            if (!number.remainder(new BigInteger("2")).equals(new BigInteger("0"))) return 0;
            number = number.divide(new BigInteger("2"));
        }
        return 1;
    }

    public static void main(String args[]) {
        PowerOfTwo obj = new PowerOfTwo();
        System.out.println(Math.pow(2, 64));
        System.out.println("147573952589676412928".length());
        System.out.println(obj.power("147573952589676412928"));
        System.out.println(obj.power("3"));
    }
}
