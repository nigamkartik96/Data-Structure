package binarysearch;

import java.util.Arrays;
import java.util.List;

public class RotatedArraySearch {
    public int search(final List<Integer> a, int b) {
        int i = 0;
        int j = a.size() - 1;

        while (i <= j) {
            int mid = (i + j) / 2;

            if (a.get(mid) == b)
                return mid;
            if (a.get(mid) >= a.get(i)) {
                if (b >= a.get(i) && b < a.get(mid))
                    j = mid - 1;
                else
                    i = mid + 1;
            } else {
                if (b > a.get(mid) && b <= a.get(j))
                    i = mid + 1;
                else
                    j = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        RotatedArraySearch obj = new RotatedArraySearch();
        List<Integer> list = Arrays.asList(4, 5, 6, 7, 0, 1, 2);
        System.out.println(obj.search(list, 4));
    }
}
