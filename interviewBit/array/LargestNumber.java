package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber {
    public String largestNumber(final List<Integer> A) {
        ArrayList<Integer> list = new ArrayList<>(A);

        Collections.sort(list, (e1, e2) -> {
            Long a = new Long(e1.toString() + e2.toString());
            Long b = new Long(e2.toString() + e1.toString());
            if (a < b) {
                return 1;
            } else if (a > b) {
                return -1;
            } else {
                return 0;
            }
        });

        StringBuilder a = new StringBuilder(list.toString().replaceAll("(, |\\[|\\])", ""));
        if (list.get(0) == 0) return "0";
        return a.toString();
    }

    public static void main(String args[]) {
        LargestNumber obj = new LargestNumber();
        List<Integer> a = new ArrayList<>();

        a.add(3);
        a.add(30);
        a.add(34);
        a.add(5);
        a.add(9);

        System.out.println(obj.largestNumber(a));
    }
}
