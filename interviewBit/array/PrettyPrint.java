package array;

import java.util.ArrayList;

public class PrettyPrint {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < A * 2 - 1; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < A * 2 - 1; j++) list.add(0);
            matrix.add(list);
        }
        int n = A * 2 - 1, m = n, k = 0, l = 0, val = A, i;
        while (k < m && l < n) {
            for (i = l; i < n; i++) {
                matrix.get(k).set(i, val);
            }
            k++;

            for (i = k; i < m; i++) {
                matrix.get(i).set(n - 1, val);
            }
            n--;

            if (k < m) {
                for (i = n - 1; i >= l; i--) matrix.get(m - 1).set(i, val);
                m--;
            }

            if (l < n) {
                for (i = m - 1; i >= k; i--) matrix.get(i).set(l, val);
                l++;
            }

            val --;
        }
        return matrix;
    }


    public static void main(String args[]) {
        PrettyPrint obj = new PrettyPrint();
        System.out.println(obj.prettyPrint(4));
    }
}
