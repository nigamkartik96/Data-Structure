/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p>
 * return 1->4->3->2->5->NULL.
 * <p>
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list. Note 2:
 * Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question.
 */
package linkedlist;

import java.util.Stack;

public class RotateLinkedList {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        int index = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = A;

        ListNode previous = dummy;
        while (++index < B && previous != null) {
            previous = previous.next;
        }
        if (null == previous) {
            return A;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode current = previous.next;
        while (index++ <= C && current != null) {
            stack.push(current);
            current = current.next;
        }
        while (!stack.isEmpty()) {
            previous.next = stack.pop();
            previous = previous.next;
        }
        previous.next = current;
        return dummy.next;
    }

    public static void main(String args[]) {
        RotateLinkedList obj = new RotateLinkedList();
        ListNode node = ListUtility.getList("1 2 3 4 5");
        node = obj.reverseBetween(node, 2, 4);
        ListUtility.traverseList(node);
    }
}
