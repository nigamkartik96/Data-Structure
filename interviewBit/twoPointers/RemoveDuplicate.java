/**
 * Remove duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.
 *
 * Note that even though we want you to return the new length, make sure to change the original array as well in place
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 *  Example:
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */
package twoPointers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class RemoveDuplicate {
    public int removeDuplicates(ArrayList<Integer> a) {
        HashSet<Integer> hs = new HashSet<>();
        hs.addAll(a);
        a.clear();
        TreeSet<Integer> ts = new TreeSet<>(hs);
        a.addAll(ts);
        return a.size();
    }

    public static void main(String ag[]) {
        RemoveDuplicate obj = new RemoveDuplicate();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(2);
        System.out.println(obj.removeDuplicates(a));
    }
}
