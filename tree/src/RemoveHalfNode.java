/**
 * Given A binary Tree, Task is to remove all the half nodes (which has only one child).
 *
 * For example consider the below tree.
 *
 * Nodes 7, 5 and 9 are half nodes as one of their child is Null. We need to remove all such half nodes and return the root pointer of following new tree.
 *
 * Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
 *
 * Input:
 * First line consists of T test cases. First line of every test case consists of N, denoting number of nodes. Second line of every test case consists of 3 elements denoting 2 nodes and a character denoting parent's left child or right child.
 *
 * Output:
 * Single line output, print the modified tree in inorder traversal.
 *
 * Constraints:
 * 1<=T<=100
 * 1<=N<=1000
 *
 * Example:
 * Input:
 * 1
 * 7
 * 2 7 L 2 5 R 7 6 R 6 1 L 6 11 R 5 9 R 9 4 L
 * Output:
 * 1 6 11 2 4
 */
public class RemoveHalfNode {
    public Node removeHalfNodes(Node root) {
        if (root == null) return null;
        root.left = removeHalfNodes(root.left);
        root.right = removeHalfNodes(root.right);
        if (root.left == null && root.right != null) return root.right;
        if (root.left != null && root.right == null) return root.left;
        return root;
    }
}
