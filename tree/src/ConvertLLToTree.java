/**
 * Given a Linked List Representation of Complete Binary Tree. The task is to construct the Binary tree.
 * <p>
 * Note : The complete binary tree is represented as a linked list in a way where if root node is stored at position i, its left, and right children are stored at position 2*i, 2*i+1 respectively.
 * Input:
 * First line of input contains number of testcases T. For each testcase, first line of input contains length of linked list and next line contains linked list elements.
 * <p>
 * Output:
 * Output of each test case will be the level order traversal of the the constructed binary tree.
 * <p>
 * User Task:
 * The task is to complete the function convert() which takes head of linked list and root of the tree as the reference. The driver code prints the level order.
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 103
 * 1 <= Ki <= 103
 * <p>
 * Example(To be used only for expected output ) :
 * Input
 * 2
 * 5
 * 1 2 3 4 5
 * 5
 * 5 4 3 2 1
 * <p>
 * Output:
 * 1 2 3 4 5
 * 5 4 3 2 1
 */
public class ConvertLLToTree {

    static class Tree {
        int data;
        Tree right;
        Tree left;

        Tree(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Tree convert(Node head, Tree node) {
        if (head == null) return null;
        node = new Tree(head.data);
        convertUtil(head, node, 1);
        return node;
    }

    static void convertUtil(Node head, Tree node, int index) {
        if (node == null) return;
        int left = getNodeFromLL(head, index * 2);
        int right = getNodeFromLL(head, index * 2 + 1);
        if (left == -1 && right == -1) {
            return;
        }

        if (left != -1) node.left = new Tree(left);
        if (right != -1) node.right = new Tree(right);

        convertUtil(head, node.left, index * 2);
        convertUtil(head, node.right, index * 2 + 1);
    }

    static int getNodeFromLL(Node head, int index) {
        int currentIndex = 1;
        Node node = null, temp = head;
        while (index != currentIndex && temp != null) {
            temp = temp.next;
            currentIndex++;
            if (currentIndex == index) {
                node = temp;
            }
        }

        return node == null ? -1 : node.data;
    }
}
