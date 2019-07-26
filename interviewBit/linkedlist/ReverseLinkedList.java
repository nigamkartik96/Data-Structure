/**
 * Reverse a linked list. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL,
 *
 * return 5->4->3->2->1->NULL.
 */
package linkedlist;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode a) {
        if (a == null) return a;
        ListNode currentNode = a, nextNode = a.next, temp;
        currentNode.next = null;
        while (nextNode != null) {
            temp = nextNode.next;
            nextNode.next = currentNode;
            currentNode = nextNode;
            nextNode = temp;
        }

        return currentNode;
    }

    public static void main(String args[]) {
        ReverseLinkedList obj = new ReverseLinkedList();
        ListUtility listUtility = new ListUtility();
        ListNode node = listUtility.getList("1 2 3 4");
        System.out.println(obj.reverseList(node));
    }
}
