/**
 * Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list.
 *
 * Input:
 * First line of input contains number of testcases T. For each testcase, first line contains length of linked list and next line contains the linked list elements.
 *
 * Output:
 * For each testcase, there will be a single line of output which contains the linked list with every k group elements reversed.
 *
 * Example:
 * Input:
 * 1
 * 8
 * 1 2 2 4 5 6 7 8
 * 4
 *
 * Output:
 * 4 2 2 1 8 7 6 5
 *
 * Explanation:
 * Testcase 2: Since, k = 4. So, we have to reverse everty group of two elements. Modified linked list is as 4, 2, 2, 1, 8, 7, 6, 5.
 */
public class ReverseGroup {
    public static Node reverse(Node head, int k) {

        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null)
            head.next = reverse(next, k);

        return prev;
    }

    public static void main(String args[]) {
        ReverseGroup obj = new ReverseGroup();
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);

        reverse(node, 4);
        System.out.println(node);
    }
}
