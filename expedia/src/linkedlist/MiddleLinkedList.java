package linkedlist;

public class MiddleLinkedList {

    public static Node getMiddle(Node head) {
        if (head == null) {
            return new Node(-1);
        }
        if (head.next == null) {
            return head;
        }

        Node fast = head.next;

        while (fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = Utility.getList();
        System.out.println(getMiddle(head).data);
    }
}
