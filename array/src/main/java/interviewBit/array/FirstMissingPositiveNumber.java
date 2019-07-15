/**
* Given an unsorted integer array, find the first missing positive integer.
* Example:
* Given [1,2,0] return 3,
* [3,4,-1,1] return 2,
* [-8, -7, -6] returns 1
* Your algorithm should run in O(n) time and use constant space.
*/
package interviewBit.array;

import java.util.ArrayList;

public class FirstMissingPositiveNumber {
    public int firstMissingPositive(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        for (Integer i: A) max = max < i ? i: max;

        if (max <= 0) return 1;

        boolean arr[] = new boolean[max + 1];
        for (Integer i: A) {
            if (i > 0) arr[i] = true;
        }
        int i = 1;
        while(i <= max && arr[i]) i++; return i;
    }

    public static void main (String args[]) {
        FirstMissingPositiveNumber obj = new FirstMissingPositiveNumber();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); list.add(0); list.add(2);

        System.out.println(obj.firstMissingPositive(list));
    }
}
