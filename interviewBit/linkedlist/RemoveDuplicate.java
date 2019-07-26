/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
package linkedlist;

public class RemoveDuplicate {
    public ListNode deleteDuplicates(ListNode a) {
        if (a == null) return a;
        if (a.next == null) return a;
        ListNode next = a.next, node = a;
        while (next != null) {
            if (node.val == next.val) {
                node.next = next.next;
                next = node.next;
            } else {
                node = next;
                next = next.next;
            }
        }

        return a;
    }

    public static void main(String args[]) {
        RemoveDuplicate obj = new RemoveDuplicate();
        ListNode node = ListUtility.getList("1 1 2 2 3 3 5 5");

        node = obj.deleteDuplicates(node);
        ListUtility.traverseList(node);
    }
}
