/**
 * Given a Binary Tree, find diameter of it.
 * The diameter of a tree is the number of nodes on the longest path between two leaves in the tree. The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
 *
 * Input Format:
 * The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains two lines of input. The first line contains number of edges. The second line contains the relation between nodes.
 *
 * Output Format:
 * For each testcase, in a new line, print the diameter.
 *
 * Your Task:
 * You need to complete the function diameter() that takes node as parameter and returns the diameter.
 *
 * Constraints:
 * 1 <= T <= 30
 * 1 <= Number of nodes <= 100
 * 1 <= Data of a node <= 1000
 *
 * Example:
 * Input:
 * 2
 * 2
 * 1 2 L 1 3 R
 * 4
 * 10 20 L 10 30 R 20 40 L 20 60 R
 * Output:
 * 3
 * 4
 *
 * Explanation:
 * Testcase1: The tree is
 *         1
 *      /      \
 *    2        3
 * The diameter is of 3 length.
 * Testcase2: The tree is
 *                            10
 *                         /        \
 *                      20         30
 *                   /       \
 *                40       60
 * The diameter is of 4 length.
 */
public class Diameter {
    int height(Node node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);
        return (left > right ? left : right) + 1;
    }

    /* Complete the function to get diameter of a binary tree */
    int diameter(Node node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int totalHeight = rightHeight + leftHeight;

        int leftD = diameter(node.left);
        int rightD = diameter(node.right);
        int max = leftD > rightD ? leftD : rightD;

        return (max > totalHeight ? max : totalHeight + 1);
    }
}
