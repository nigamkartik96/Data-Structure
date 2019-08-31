/**
 * Given a singly linked list of size N of integers. The task is to check if the given linked list is palindrome or not.
 *
 * Input:
 * First line of input contains number of testcases T. For each testcase, first line of input contains length of linked list N and next line contains N integers as data of linked list.
 *
 * Output:
 * For each test case output will be 1 if the linked list is a palindrome else 0.
 *
 * User Task:
 * The task is to complete the function isPalindrome() which takes head as reference as the only parameter and returns true or false if linked list is palindrome or not respectively.
 *
 * Constraints:
 * 1 <= T <= 103
 * 1 <= N <= 50
 *
 * Example(To be used only for expected output):
 * Input:
 * 2
 * 3
 * 1 2 1
 * 4
 * 1 2 3 4
 *
 * Output:
 * 1
 * 0
 *
 * Explanation:
 * Testcase 1: 1 2 1, linked list is palindrome.
 */
public class PalindromeCheck {
    boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        Node node = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            node = node.next;
            fast = fast.next.next;
        }

        fast = node.next;

        String s1 = "", s2 = "";

        while (fast != null) {
            s1 += head.data;
            head = head.next;
            s2 = fast.data + s2;
            fast = fast.next;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
}
