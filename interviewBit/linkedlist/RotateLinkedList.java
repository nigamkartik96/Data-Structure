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
