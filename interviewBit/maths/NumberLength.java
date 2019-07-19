/**
 * Given a set of digits (A) in sorted order, find how many numbers of length B are possible whose value is less than number C.
 * <p>
 * NOTE: All numbers can only have digits from the given set.
 * Examples:
 * <p>
 * Input:
 * 0 1 5
 * 1
 * 2
 * Output:
 * 2 (0 and 1 are possible)
 * <p>
 * Input:
 * 0 1 2 5
 * 2
 * 21
 * Output:
 * 5 (10, 11, 12, 15, 20 are possible)
 * Constraints:
 * <p>
 * 1 <= B <= 9, 0 <= C <= 1e9 & 0 <= A[i] <= 9
 */
package maths;

import java.util.ArrayList;

public class NumberLength {
    public int solve(ArrayList<Integer> A, int B, int C) {

        int na = A.size();
        if (na == 0)
            return 0;

        boolean[] flag = new boolean[10];
        for (int i = 0; i < na; i++)
            flag[A.get(i)] = true;

        String s = "" + C;
        if (B > s.length())
            return 0;
        else if (B < s.length()) {
            if (B == 1)
                return na;
            return ((int) Math.pow(na, B - 1)) * (A.get(0) == 0 ? na - 1 : na);
        }

        int ans = 0;
        for (int i = 0; i < B; i++) {
            for (int j = 0; j < (s.charAt(i) - '0'); j++) {
                if ((i == 0 && j == 0) || !flag[j])
                    continue;
                ans += Math.pow(na, B - i - 1);
            }
            if (!flag[s.charAt(i) - '0'])
                break;
        }
        if (flag[0] && C > 0 && 1 == B)
            ans++;
        return ans;
    }


    public static void main(String args[]) {
        NumberLength obj = new NumberLength();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(5);
        System.out.println(obj.solve(list, 1, 2));
    }
}
