/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 *
 * Input Format
 *
 * The only argument given is integer array A.
 * Output Format
 *
 * Return the total water it is able to trap after raining..
 * For Example
 *
 * Input 1:
 *     A = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output 1:
 *     6
 * Explaination 1: <img src="http://i.imgur.com/0qkUFco.png">
 *
 *     In this case, 6 units of rain water (blue section) are being trapped.
 */
package stack;

import java.util.Arrays;
import java.util.List;

public class RainWaterTrapped {
    public int trap(final List<Integer> A) {
        int total = 0;
        int leftmax = A.get(0), rightmax = A.get(A.size() - 1);
        int low = 0, high = A.size() - 1;
        while (low < high) {

            if (A.get(low) < A.get(high)) {
                if (A.get(low) > leftmax)
                    leftmax = A.get(low);
                else {
                    total += leftmax - A.get(low);
                }
                low++;

            } else {
                if (A.get(high) > rightmax)
                    rightmax = A.get(high);
                else {
                    total += rightmax - A.get(high);
                }
                high--;

            }
        }
        return total;
    }

    public static void main(String args[]) {
        RainWaterTrapped obj = new RainWaterTrapped();
        List<Integer> a = Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1);
        System.out.println(obj.trap(a));
    }
}
