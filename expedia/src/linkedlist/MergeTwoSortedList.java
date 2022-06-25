package linkedlist;

public class MergeTwoSortedList {

    private static Node getMergedList(Node head1, Node head2) {
        Node finalNode = null;
        Node head = null;
        Node temp;
        while (head1 != null && head2 != null) {
            if (head1.data > head2.data) {
                temp = head2;
                head2 = head2.next;
            } else {
                temp = head1;
                head1 = head1.next;
            }

            if (finalNode == null) {
                finalNode = temp;
                head = temp;
            } else {
                finalNode.next = temp;
                finalNode = finalNode.next;
            }
        }

        if (head1 != null) {
            finalNode.next = head1;
        }

        if (head2 != null) {
            finalNode.next = head2;
        }

        return head;
    }

    public static void main(String[] args) {
        Node head1 = Utility.getList();
        Node head2 = Utility.getList();

        Utility.printList(getMergedList(head1, head2));
    }
}
