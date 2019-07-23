/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm’s runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example:
 * <p>
 * Given [5, 7, 7, 8, 8, 10]
 * <p>
 * and target value 8,
 * <p>
 * return [3, 4].
 */
package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRange {
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        int n = a.size();
        int left, right;
        left = binSearch(a, b, 0, n - 1);
        right = left;

        if (left != -1) {
            int curLeft = left, curRight = right;
            while (curLeft != -1 || curRight != -1) {
                if (curLeft != -1) {
                    curLeft = binSearch(a, b, 0, curLeft - 1);
                    if (curLeft != -1) left = curLeft;
                }

                if (curRight != -1) {
                    curRight = binSearch(a, b, curRight + 1, n - 1);
                    if (curRight != -1) right = curRight;
                }
            }
        }

        ArrayList list = new ArrayList<>();
        list.add(left);
        list.add(right);
        return list;
    }

    int binSearch(final List<Integer> a, int b, int low, int high) {
        if (low > high) return -1;
        int mid = (high + low) / 2;

        if (a.get(mid) == b) return mid;
        if (b > a.get(mid)) return binSearch(a, b, mid + 1, high);
        return binSearch(a, b, low, mid - 1);
    }

    public static void main(String args[]) {
        SearchRange obj = new SearchRange();
        List<Integer> list = Arrays.asList(5, 7, 7, 8, 8, 10);
        System.out.println(obj.searchRange(list, 8));
    }
}
