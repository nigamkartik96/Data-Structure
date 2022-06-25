package linkedlist;

public class ReverseLinkedList {


    private static Node reverseList(Node head) {
        if (head == null || head.next == null) return head;

        Node curr = head;
        Node prev = null;
        Node next = head.next;

        while (next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }


    public static void main(String[] args) {
        Node head = Utility.getList();
        Utility.printList(reverseList(head));
    }
}
