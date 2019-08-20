/**
 * Given a binary tree, check if the tree can be folded or not. A tree can be folded if left and right subtrees of the tree are structure wise same. An empty tree is considered as foldable.
 *
 * Consider the below trees:
 * (a) and (b) can be folded.
 * (c) and (d) cannot be folded.
 *
 * (a)
 *        10
 *      /    \
 *     7      15
 *      \    /
 *       9  11
 * (b)
 *         10
 *        /  \
 *       7    15
 *      /      \
 *     9       11
 * (c)
 *         10
 *        /  \
 *       7   15
 *      /    /
 *     5   11
 * (d)
 *          10
 *        /   \
 *       7     15
 *     /  \    /
 *    9   10  12
 * Input:
 * First line of input contains number of testcases T. For each testcase, there will be two lines, first of which containing the number of edges (between two nodes) in the tree. Next line contains N pairs (considering a and b) with a 'L' (means node b on left of a) or 'R' (means node b on right of a) after a and b.
 *
 * Output Format:
 * Print "Yes" (without quotes) if the tree is foldable and "No" ( without quotes) if it is unfoldable.
 *
 * Your Task:
 * The task is to complete the function isFoldable() that takes root of the tree as input and returns true or false.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= n <= 103
 * 1 <= data of node <= 104
 *
 * Example:
 * Input:
 * 2
 * 4
 * 10 7 L 7 9 R 10 15 R 15 11 L
 * 4
 * 10 7 L 7 5 L 10 15 R 15 11 L
 *
 * Output:
 * Yes
 * No
 */
public class FoldableBinaryTree {
    public static boolean isFoldable(Node root) {
        if (root == null) return true;

        return isFoldableUtil(root.left, root.right);
    }

    public static boolean isFoldableUtil(Node left, Node right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        return isFoldableUtil(left.left, right.right)
                && isFoldableUtil(left.right, right.left);
    }
}
