package linkedlist;

public class RemoveNthFromEnd {

    private static Node removeNthNode(Node head, int n) {
        int len = Utility.length(head);

        if (len == 0 || len < n) {
            return head;
        }

        int delta = len - n;
        Node current = head;
        Node prev = null;
        while (delta != 0) {
            prev = current;
            current = current.next;
            delta = delta - 1;
        }

        if (prev != null) {
            prev.next = current.next;
        } else {
            current = current.next;
            head = current;
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = Utility.getList();
        Utility.printList(removeNthNode(head, 3));
        Utility.printList(removeNthNode(head, 2));
    }
}
