/**
 * Given a Binary Search Tree (BST), modify it so that all greater values in the given BST are added to every node.
 * In this function problem, the task is to complete the function modify which takes one argument: Address of the root of the BST. The function should contain the logic to modify the BST so that in the modified BST, every node has a value equal to the sum of its value in the original BST and  values of all the elements larger than it in the original BST.
 *
 * The BST node structure has 3 fields, a data part which stores the data, a left pointer which points to the left element of the BST and a right pointer which points to the right node of the BST.
 *
 * There are multiple test cases. For each test case, this function will be called individually.
 *
 * Input:
 * The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. Each test case consists of two lines. First line of each test case contains an integer N denoting the no of nodes of the BST . Second line of each test case consists of 'N' space separated integers denoting the elements of the BST. These elements are inserted into BST in the given order.
 *
 * Output:
 * Print the inorder traversal of the modified BST.
 *
 * Expected Time Complexity: O(N)
 *
 * Constraints:
 * 1<=T<=100
 * 1<=N<=200
 *
 * Example:
 * Input:
 * 1
 * 7
 * 50 30 20 40 70 60 80     (Elements are inserted into BST in this order only)
 *
 * Output:
 * 350 330 300 260 210 150 80         (Inorder Traversal of the modified BST)
 *
 * Explanation:
 *
 *               50
 *            /      \
 *          30        70
 *         /   \      /  \
 *       20    40    60   80
 *
 * The above tree should be modified to following
 *
 *               260
 *            /      \
 *          330        150
 *         /   \       /  \
 *       350   300    210   80
 */
public class ModifyValues {
    int max = 0;

    void modify(Node root) {
        if (root == null) {
            return;
        }
        modify(root.right);
        root.data += max;
        if (root.data > max) {
            max = root.data;
        }
        modify(root.left);
    }
}
