/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 *
 * begin to intersect at node c1.
 *
 *  Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
package linkedlist;

public class MergePoint {
    ListUtility listUtility = new ListUtility();
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        int m = length(a);
        int n = length(b);

        if (m > n) {
            ListNode temp = a;
            a = b;
            b = temp;

            int t = m;
            m = n;
            n = t;
        }

        int diff = n - m;
        while (diff != 0) {
            b = b.next;
            diff--;
        }

        while (a != null && b != null) {
            if (a == b) return a;
            a = a.next;
            b = b.next;
        }
        return null;
    }

    public int length(ListNode a) {
        int count = 0;
        ListNode head = a;
        while (a != null) {
            count++;
            a = a.next;
        }
        a = head;
        return count;
    }

}
