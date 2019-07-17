/**
 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
 *
 * Example:
 *
 * Input : [1, 0]
 * Return : [0, 1]
 *  Lets say N = size of the array. Then, following holds true :
 * All elements in the array are in the range [0, N-1]
 * N * N does not overflow for a signed integer
 */
package interviewBit.maths;

import java.util.ArrayList;

public class RearrangeArray {
    public void arrange(ArrayList<Integer> a) {
        int n = a.size();
        for (int i = 0; i < a.size(); i++) {
            int val = a.get(i), temp = a.get(a.get(i));
            val += (temp % n) * n;
            a.set(i, val);
        }
        for (int i = 0; i < a.size(); i++) {
            a.set(i, (a.get(i)) / n);
        }
    }

    public static void main(String args[]) {
        RearrangeArray obj = new RearrangeArray();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(0);
        list.add(2);
        list.add(1);
        list.add(3);
        obj.arrange(list);
        System.out.println(list);
    }
}
