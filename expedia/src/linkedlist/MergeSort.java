package linkedlist;

public class MergeSort {

    private static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = MiddleLinkedList.getMiddle(head);
        Node nextOfMiddle = middle.next;
        Node left = mergeSort(markNextNull(head, middle));
        Node right = mergeSort(nextOfMiddle);

        return MergeTwoSortedList.getMergedList(left, right);
    }

    private static Node markNextNull(Node head, Node middle) {
        Node current = head;
        while (head != null && head != middle) {
            head = head.next;
        }
        if (head != null)
            head.next = null;
        return current;
    }

    public static void main(String[] args) {
        Node head = Utility.getUnSortedList();
        Utility.printList(mergeSort(head));
    }
}
