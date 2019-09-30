/**
 * Given a Binary Tree having random pointers clone the Binary Tree. The task is to complete the function cloneTree which take one argument the root of the tree to be copied and should return the root of the cloned tree.
 *
 * Input:
 * The first line of input contains the no of test cases. Then T test cases follow. Each test case contains 2 lines the first line contains and integer N denoting the no of edges of the tree and then in the next line are N space separated queries .The query on tree are of three types
 * a) a b L  (Represents that b is the left child of a)
 * b) a b R (Represents that b is the right child of a)
 * c) a b X (Represents a random pointer from node a to node b)
 *
 * Output:
 * Your function should return the root of the cloned tree. The output will be 1 if the tree is successfully cloned.
 *
 * Constraints:
 * 1 <=T<= 30
 * 1 <=Number of nodes<= 100
 * 1 <=Data of a node<= 1000
 *
 * Example(To be used only for expected output):
 * Input
 * 1
 * 6
 * 6 3 L 6 8 R 3 1 L 3 5 R 1 3 X 5 6 X
 *
 * Output
 * 1
 *
 * Above test case represents the below tree with 6 edges .
 */

public class CloneTree {
    static class Tree {
        int data;
        Tree left, right, random;

        Tree(int d) {
            data = d;
            left = null;
            right = null;
            random = null;
        }

        @Override
        public String toString() {
            return "[ data = " + data + ", left = " +
                    left + ", right = " + right + ", random = " + random + "]";
        }
    }

    public static Tree cloneTree(Tree tree) {

        if (tree == null) return null;
        Tree root = new Tree(tree.data);
        cloneTree(tree, root);
        return root;
    }


    public static void cloneTree(Tree tree, Tree cloneTree) {
        if (tree == null) return;

        if (tree.left != null) {
            cloneTree.left = new Tree(tree.left.data);
        }

        if (tree.right != null) {
            cloneTree.right = new Tree(tree.right.data);
        }

        cloneTree(tree.left, cloneTree.left);
        cloneTree(tree.right, cloneTree.right);
    }
}
