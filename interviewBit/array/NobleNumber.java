/**
 * Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
 * If such an integer is found return 1 else return -1.
 */
package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class NobleNumber {
    static boolean positiveFlag = true, existFlag = false;
    static int currentLen = 0;

    public int solve(List<Integer> A) {
        Collections.sort(A);

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int a : A) {
            if (!map.containsKey(a)) map.put(a, 1);
            else map.put(a, map.get(a) + 1);
            positiveFlag = a > 0;
        }
        int n = A.size();
        map.forEach((k, v) -> {
            currentLen += v;
            if (v != 0 && (n - currentLen) == k) existFlag = true;
            if (k < 0 && v != 0 && (n - currentLen) == Math.abs(k) && positiveFlag) existFlag = true;
        });
        return existFlag ? 1 : -1;
    }

    public static void main(String args[]) {
        NobleNumber obj = new NobleNumber();
        List<Integer> list = Arrays.asList(6, -3, -2, 0, 0, -1, 0);
        System.out.println(obj.solve(list));
    }
}
