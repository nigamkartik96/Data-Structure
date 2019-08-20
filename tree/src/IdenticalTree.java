/**
 * Given two binary trees, the task is to find if both of them are identical or not.
 *
 * Input:
 * The task is to complete the method isIdentical(), which takes 2 argument, the roots r1 and r2 of the Binary Trees. The struct Node has a data part which stores the data, pointer to left child and pointer to right child.
 * There are multiple test cases. For each test case, this method will be called individually.
 *
 * Output:
 * The function should return true if both trees are identical else false.
 *
 * User task:
 * Since this is a functional problem you don't have to worry about input, you just have to complete the function isIdentical() that takes two roots as parameter and returns true or false. The printing is done by the driver code.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= Number of nodes <= 100
 * 1 <=Data of a node <= 1000
 *
 * Example:
 * Input
 * 2
 * 2
 * 1 2 L 1 3 R
 * 2
 * 1 2 L 1 3 R
 * 2
 * 1 2 L 1 3 R
 * 2
 * 1 3 L 1 2 R
 *
 * Output
 * 1
 * 0
 *
 * Explanation:
 * Testcase 1: There are two trees both having 3 nodes and 2 edges, both trees are identical having the root as 1, left child of 1 is 2 and right child of 1 is 3.
 * Testcase 2: There are two trees both having 3 nodes and 2 edges, but both trees are not identical.
 */

public class IdenticalTree {
    boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        else if (root1 == null || root2 == null || root1.data != root2.data) return false;
        else
            return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);

    }
}
