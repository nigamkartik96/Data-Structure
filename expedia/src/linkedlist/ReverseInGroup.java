package linkedlist;

public class ReverseInGroup {

    private static Node reverseInGroup(int size, Node head) {
        if (head == null || head.next == null) return head;

        return head;
    }

    public static void main(String[] args) {
        Node head = Utility.getList();
        Utility.printList(reverseInGroup(2, head));
    }
}
