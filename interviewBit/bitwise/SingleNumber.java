/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example :
 *
 * Input : [1 2 2 3 1]
 * Output : 3
 */
package bitwise;

import java.util.Arrays;
import java.util.List;

public class SingleNumber {
    public int singleNumber(final List<Integer> A) {
        int number = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            number = number ^ A.get(i);
        }
        return number;
    }

    public static void main(String args[]) {
        SingleNumber obj = new SingleNumber();
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 1);
        System.out.println(obj.singleNumber(list));
    }
}
