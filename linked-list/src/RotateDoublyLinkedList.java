public class RotateDoublyLinkedList {

    class Node {

        int data;
        Node prev, next;

        @Override
        public String toString() {
            return "-" + this.data + "-";
        }

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static void main(String args[]) {
        RotateDoublyLinkedList obj = new RotateDoublyLinkedList();
        Node head = obj.initializeList();
        head = obj.rotateP(head, 9);

        while (head.next != null) {
            System.out.print("-" + head.data + "-");
            head = head.next;
        }
    }



    Node initializeList() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(5);

        return head;
    }


    Node rotateP(Node head, int p) {
        if (head == null) return head;
        if (head.next == null) return head;
        Node tail = head;
        int count = 1;

        while (tail.next != null) {
            count++;
            tail = tail.next;
        }

        p = p % count;

        while (p != 0) {
            Node node = new Node(head.data);
            node.prev = tail;
            tail.next = node;
            tail = node;
            head = head.next;
            p--;
        }

        return head;
    }

}
