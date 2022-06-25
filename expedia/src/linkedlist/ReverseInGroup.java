package linkedlist;

public class ReverseInGroup {

    private static Node reverseInGroup(int size, Node head) {
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

        if (next != null) {
            head.next = reverseInGroup(size, next);
        }

        return prev;
    }

    public static void main(String[] args) {
        Node head = Utility.getList();
        Utility.printList(reverseInGroup(7, head));
    }
}
