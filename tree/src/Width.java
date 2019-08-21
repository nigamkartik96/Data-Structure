/**
 * Given a Binary Tree, find the maximum width of it. Maximum width is defined as the maximum number of nodes in any level.
 * For example, maximum width of following tree is 4 as there are 4 nodes at 3rd level.
 *
 *           1
 *        /     \
 *      2        3
 *    /    \    /    \
 *   4    5   6    7
 *     \
 *       8
 *
 * Input Format:
 * The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains two lines of input. The first line contains number of edges. The second line contains relation between the nodes.
 *
 * Output Format:
 * For each testcase, in a new line, print the maximum width.
 *
 * Your Task:
 * You don't have to read any input. Just complete the function getMaxWidth() that takes node as parameter and returns the maximum width. The printing is done by the driver code.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= edges <= 100
 * 1 <= nodes values <= 1000
 *
 * Example:
 * Input:
 * 2
 * 2
 * 1 2 R 1 3 L
 * 4
 * 10 20 L 10 30 R 20 40 L 20 60 R
 *
 * Output:
 * 2
 * 2
 *
 * Explanation:
 * Testcase1: The tree is
 *         1
 *      /      \
 *    3       2
 * The second level has 2 nodes and hence the width is 2.
 *
 * Testcase2: The tree is
 *                            10
 *                         /        \
 *                      20         30
 *                   /       \
 *                40       60
 * Both second and third level have 2 nodes and hence max width is 2.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Width {
    class Level {
        Node node;
        int level;

        Level(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    int getMaxWidth(Node root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Level> queue = new LinkedList<>();
        queue.add(new Level(root, 0));
        while (queue.size() != 0) {
            Level level = queue.poll();
            if (!map.containsKey(level.level)) map.put(level.level, 1);
            else map.put(level.level, map.get(level.level) + 1);

            if (level.node.right != null) queue.add(new Level(level.node.right, level.level + 1));
            if (level.node.left != null) queue.add(new Level(level.node.left, level.level + 1));
        }
        int max = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) max = entry.getValue();
        }

        return max;
    }
}
