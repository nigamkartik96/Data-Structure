/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * <p>
 * Note:
 * If n is greater than the size of the list, remove the first node of the list.
 * Try doing it using constant additional space.
 */
package linkedlist;

public class DeleteFromLast {
    public ListNode removeNthFromEnd(ListNode a, int b) {
        int len = ListUtility.length(a), diff = len - b, i = 0;
        if (a == null) return a;
        if (diff <= 0) {
            a = a.next;
            return a;
        }
        ListNode head = a;
        while (i < diff - 1) {
            head = head.next;
            i++;
        }

        if (head.next != null)
            head.next = head.next.next;
        else
            head.next = null;

        return a;
    }

    public static void main(String args[]) {
        DeleteFromLast obj = new DeleteFromLast();
        ListNode node = ListUtility.getList("1 2 3 4 5");
        node = obj.removeNthFromEnd(node, 2);
        ListUtility.traverseList(node);
    }
}
