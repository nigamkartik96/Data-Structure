/**
 * Given a binary tree, complete the function that returns true if the tree satisfies the following property:
 * For every node, data value must be equal to the sum of data values in left and right children. Consider data value as 0 for NULL child.  Also, leaves are considered to follow the property.
 *
 * Input Format:
 * The first line consists of T test cases. The first line of every test case consists of N, denoting the number of edges in the tree. The second and third line of every test case consists of N, nodes of the binary tree.
 *
 * Output Format:
 * Return 1 if the given tree satisfies the given property else return 0.
 *
 * Your Task:
 * This is a function problem. You need to only complete the given function isSumProperty() that returns 0 or 1. The printing is done by the driver code.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 100
 *
 * Example:
 * Input:
 * 2
 * 3
 * 4 1 L 4 3 R 3 3 L
 * 5
 * 10 8 L 10 2 R 8 3 L 8 5 R 2 2 L
 *
 * Output:
 * 1
 * 1
 *
 * Explanation:
 * Testcase 1: Tree is like:
 *               4
 *            /     \
 *          1       3
 *                  /
 *                3
 *
 * Here, every node is sum of its left and right child.
 */
public class SumTree {

    public static int isSumProperty(Node node) {
        if (node == null) return 1;
        int left = isSumProperty(node.left);
        if (node.left != null && node.right != null) {
            if (node.data != (node.left.data + node.right.data)) return 0;
        } else if (node.left != null) {
            if (node.data != node.left.data) return 0;
        } else if (node.right != null) {
            if (node.right.data != node.data) return 0;
        }
        int right = isSumProperty(node.right);
        if (right == 1 && left == 1)
            return 1;
        else return 0;
    }
}
