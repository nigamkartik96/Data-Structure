/**
 * Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
 * If such an integer is found return 1 else return -1.
 */
package array;

import java.util.*;

public class NobleNumber {
    public int solve(List<Integer> A) {
        Collections.sort(A);
        // System.out.println(A);
        boolean flag = true;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int a : A) {
            if (!map.containsKey(a)) map.put(a, 1);
            else map.put(a, map.get(a) + 1);
            if (a > 0) flag = false;
        }
        int n = A.size(), currentLen = 0;
        /*for(int i = 0; i < arr.length; i++) {
            currentLen += arr[i];
            // System.out.println(currentLen + " " + n + " " + (n - currentLen) + " " + i);
            if(arr[i] != 0 && (n - currentLen) == i) return 1;
        }*/

        /*map.forEach((k, v) -> {
            currentLen += v;
            System.out.println(currentLen + " " + n + " " + (n - currentLen) + " " + k);
            if(v != 0 && (n - currentLen) == k) flag = 1;
        });*/
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            currentLen += v;
            // System.out.println(currentLen + " " + n + " " + (n - currentLen) + " " + k);
            if (v != 0 && (n - currentLen) == k) return 1;
            if (k < 0 && v != 0 && (n - currentLen) == Math.abs(k) && flag) return 1;
        }
        return -1;
    }

    public static void main(String args[]) {
        NobleNumber obj = new NobleNumber();
        List<Integer> list = Arrays.asList(6, -3, -2, 0, 0, -1, 0);
        System.out.println(obj.solve(list));
    }
}
