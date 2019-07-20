/**
 * Given an array a[1..N]. For each element at position i (1 <= i <= N). Where
 * <p>
 * L(i) is defined as closest index j such that j < i and a[j] > a[i]. If no such j exists then L(i) = 0.
 * R(i) is defined as closest index k such that k > i and a[k] > a[i]. If no such k exists then R(i) = 0.
 * LRProduct(i) = L(i)*R(i) .
 * <p>
 * We need to find an index with maximum LRProduct
 * <p>
 * Examples:
 * <p>
 * Input : 1 1 1 1 0 1 1 1 1 1
 * Output : 15
 *
 * For {1, 1, 1, 1, 0, 1, 1, 1, 1, 1} all element are same except 0. So only for zero their
 * exist greater element and for others it will be zero. for zero, on left 4th element is closest
 * and greater than zero and on right 6th element is closest and greater. so maximum
 * product will be 3*5 = 24.
 *
 *
 * <p>
 * Input : 5 4 3 4 5
 * Output : 3
 * For {5, 4, 3, 4, 5}, L[] = {0, 1, 2, 1, 0} and R[]
 * = {0, 5, 4, 5, 0},
 * LRProduct = {0, 5, 8, 5, 0} and max in this is 3.
 */
package array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Maxpprod {
    public long maxSpecialProduct(ArrayList<Integer> A) {
        int n = A.size();
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);

        for (int i = 1; i < n; i++) {
            while (!q.isEmpty()) {
                if (A.get(q.getLast()) > A.get(i)) break;
                q.removeLast();
            }
            left[i] = (q.isEmpty()) ? 0 : q.getLast();
            q.addLast(i);
        }
        q = new ArrayDeque<>();
        q.addLast(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!q.isEmpty()) {
                if (A.get(q.getLast()) > A.get(i)) break;
                q.removeLast();
            }
            right[i] = (q.isEmpty()) ? 0 : q.getLast();
            q.addLast(i);
        }
        long mx = -1;
        for (int i = 0; i < n; i++) {
            mx = Long.max(mx, 1L * left[i] * right[i]);
        }
        return (int) (mx % 1000000007);
    }


    public static void main(String args[]) {
        Maxpprod obj = new Maxpprod();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(9);
        list.add(6);
        list.add(8);
        list.add(6);
        list.add(4);
        list.add(6);
        list.add(9);
        list.add(5);
        list.add(4);
        list.add(9);
        System.out.println(obj.maxSpecialProduct(list));
    }
}
