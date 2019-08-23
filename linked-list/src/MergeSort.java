/**
 * Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
 * <p>
 * Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.
 * <p>
 * Input:
 * First line of input contains number of testcases T. For each testcase, first line of input contains number of nodes in the linked list and next line contains N elements of the linked list.
 * <p>
 * Output:
 * For each test, in a new line, print the sorted linked list.
 * <p>
 * Your Task:
 * For C++ and Python: The task is to complete the function mergeSort() which sort the linked list using merge sort function.
 * For Java: The task is to complete the function mergeSort() and return the node which can be used to print the sorted linked list.
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 105
 * <p>
 * Example:
 * Input:
 * 2
 * 5
 * 3 5 2 4 1
 * 3
 * 9 15 0
 * <p>
 * Ouput:
 * 1 2 3 4 5
 * 0 9 15
 * <p>
 * Explanation:
 * Testcase 1: After sorting the given linked list, the resultant matrix will be 1->2->3->4->5.
 */
public class MergeSort {
    static Node getMiddle(Node head) {
        if (head == null) return null;
        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static Node sort(Node left, Node right) {
        Node list = null;
        if (right == null) return left;
        if (left == null) return right;

        if (left.data <= right.data) {
            list = left;
            list.next = sort(left.next, right);
        } else {
            list = right;
            list.next = sort(left, right.next);
        }

        return list;
    }

    static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        Node sortedList = sort(left, right);
        return sortedList;
    }
}
