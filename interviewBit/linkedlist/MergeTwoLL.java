/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.
 *
 * For example, given following linked lists :
 *
 *   5 -> 8 -> 20
 *   4 -> 11 -> 15
 * The merged list should be :
 *
 * 4 -> 5 -> 8 -> 11 -> 15 -> 20
 */
package linkedlist;

public class MergeTwoLL {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode temp, node;
        if (a.val < b.val) {
            temp = new ListNode(a.val);
            a = a.next;
        } else {
            temp = new ListNode(b.val);
            b = b.next;
        }
        node = temp;
        while (a != null && b != null) {
            if (a.val < b.val) {
                temp.next = new ListNode(a.val);
                a = a.next;
            } else {
                temp.next = new ListNode(b.val);
                b = b.next;
            }
            temp = temp.next;
        }

        while (a != null) {
            temp.next = new ListNode(a.val);
            a = a.next;
            temp = temp.next;
        }

        while (b != null) {
            temp.next = new ListNode(b.val);
            b = b.next;
            temp = temp.next;
        }

        return node;
    }

    public static void main(String args[]) {
        MergeTwoLL obj = new MergeTwoLL();
        ListNode a = ListUtility.getList("1 3 5 7");
        ListNode b = ListUtility.getList("2 4 6 8");
        a = obj.mergeTwoLists(a, b);
        ListUtility.traverseList(a);
    }
}
