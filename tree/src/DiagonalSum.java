/**
 * Consider lines of slope -1 passing between nodes (dotted lines in below diagram). The diagonal sum in a binary tree is the sum of all node’s data lying between these lines. Given a Binary Tree, print all diagonal sums.
 *
 * DiagonalSum
 *
 * Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
 *
 * Input:
 * The first line consists of T test cases. The first line of every test case consists of N, denoting the number of edges in the tree. The second and third line of every test case consists of N, nodes of the binary tree.
 *
 * Output:
 * Print space separated integers which are the diagonal sums for every diagonal present in the tree with slope -1.
 *
 * Constraints:
 * 1<=T<=100
 * 1<=N<=100
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
 * 7 4
 * 12 15 3
 */

import java.util.HashMap;
import java.util.Map;

public class DiagonalSum {
    HashMap<Integer, Integer> sumofDiagonals;// = new HashMap<>();
    public void diagonalsum(Node root) {
        sumofDiagonals = new HashMap<>();
        getDiagonalSum(root, 0);
        for (Map.Entry<Integer, Integer> entry : sumofDiagonals.entrySet())
            System.out.print(entry.getValue() + " ");
    }

    void getDiagonalSum(Node node, int d) {
        if (node == null) return;
        if (sumofDiagonals.containsKey(d)) {
            sumofDiagonals.put(d, sumofDiagonals.get(d) + node.data);
        } else {
            sumofDiagonals.put(d, node.data);
        }
        getDiagonalSum(node.left, d + 1);
        getDiagonalSum(node.right, d);
    }
}
