/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * For example:
 *
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
package linkedlist;

public class RotateList {
    public ListNode rotateRight(ListNode a, int b) {
        ListNode last = a;
        while (last.next != null) last = last.next;
        int len = ListUtility.length(a);
        last.next = a;
        b = b % len;
        if (b != 0) {
            int move = len - b;
            while (move != 0) {
                last = last.next;
                a = last.next;
                move--;
            }
        }
        last.next = null;
        return a;
    }

    public static void main(String args[]) {
        RotateList obj = new RotateList();
        ListNode node = ListUtility.getList("1 2 3 4 5");

        node = obj.rotateRight(node, 2);
        ListUtility.traverseList(node);
    }
}
