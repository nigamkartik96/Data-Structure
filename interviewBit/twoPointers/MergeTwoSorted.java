/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 *  Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
 * TIP: C users, please malloc the result into a new array and return the result.
 * If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after your code is executed should be m + n
 *
 * Example :
 *
 * Input :
 *          A : [1 5 8]
 *          B : [6 9]
 *
 * Modified A : [1 5 6 8 9]
 */
package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSorted {
    public void merge(List<Integer> a, List<Integer> b) {
        int i = -1, j = 0;
        while (++i < a.size() && j < b.size()) if (a.get(i) > b.get(j)) a.add(i, b.get(j++));

        while (j < b.size()) {
            a.add(i, b.get(j));
            i++;
            j++;
        }
    }

    public static void main(String args[]) {
        MergeTwoSorted obj = new MergeTwoSorted();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(8);
        List<Integer> b = Arrays.asList(9, 10);
        obj.merge(a, b);
        System.out.println(a);
    }
}
