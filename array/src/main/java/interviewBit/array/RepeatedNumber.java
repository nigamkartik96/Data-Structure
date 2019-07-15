/**
 * Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
 *
 * Sample Input:
 *
 * [3 4 1 4 1]
 * Sample Output:
 *
 * 1
 * If there are multiple possible answers ( like in the sample case above ), output any one.
 *
 * If there is no duplicate, output -1
 */
package interviewBit.array;

import java.util.ArrayList;
import java.util.List;

public class RepeatedNumber {
    public int repeatedNumber(final List<Integer> a) {
        int maxItem = Integer.MIN_VALUE;
        for (Integer value : a) maxItem = maxItem < value ? value : maxItem;
        int[] arr = new int[maxItem + 1];
        int duplicateValue = -1;
        for (Integer value : a) {
            arr[value] += 1;
            if (arr[value] > 1) duplicateValue = value;
        }

        return duplicateValue;
    }

    public static void main(String args[]) {
        RepeatedNumber obj = new RepeatedNumber();

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(4);
        list.add(4);

        System.out.println(obj.repeatedNumber(list));
    }
}
