public class AddTwoNumbers {
    public Node addTwoNumbers(Node l1, Node l2) {
        int carry = 0;
        Node node = null, temp = null;
        while (l1 != null && l2 != null) {
            int sum = l1.data + l2.data + carry;
            if (node == null) {
                node = new Node(sum % 10);
                temp = node;
            } else {
                node.next = new Node(sum % 10);
                node = node.next;
            }
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.data + carry;
            if (node == null) {
                node = new Node(sum % 10);
                temp = node;
            } else {
                node.next = new Node(sum % 10);
                node = node.next;
            }
            carry = sum / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.data + carry;
            if (node == null) {
                node = new Node(sum % 10);
                temp = node;
            } else {
                node.next = new Node(sum % 10);
                node = node.next;
            }
            carry = sum / 10;
            l2 = l2.next;
        }

        if (carry != 0) {
            node.next = new Node(carry);
        }
        return temp;
    }
}
