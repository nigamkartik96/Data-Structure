package linkedlist;

public class KAltReverseGroupLL {

    private static Node kAltReverseInGroup(Node head, int size) {
        if (head == null) return null;

        Node current = head;
        Node prev = null;
        Node next = null;

        int count = 0;

        while (count < size && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (head != null) {
            head.next = current;
        }

        count = 0;

        while (count < size - 1 && current != null) {
            current = current.next;
            count++;
        }

        if (current != null) {
            current.next = kAltReverseInGroup(current.next, size);
        }

        return prev;
    }

    public static void main(String[] args) {
        Node head = Utility.getList();
        Utility.printList(kAltReverseInGroup(head, 2));
    }
}
