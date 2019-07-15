package interviewBit;

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
