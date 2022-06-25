package linkedlist;

public class MiddleLinkedList {

    private static int getMiddle(Node head) {
        if (head == null) {
            return -1;
        }
        if (head.next == null) {
            return head.data;
        }

        Node current = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            current = current.next;
            fast = fast.next.next;
        }

        return current.data;
    }

    public static void main(String[] args) {
        Node head = Utility.getList();
        System.out.println(getMiddle(head));
    }
}
