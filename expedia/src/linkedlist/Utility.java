package linkedlist;

public class Utility {
    public static Node getList() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        return head;
    }

    public static Node getUnSortedList() {
        Node head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next.next = new Node(4);

        return head;
    }

    public static void printList(Node head) {
        Node curr = head;

        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
