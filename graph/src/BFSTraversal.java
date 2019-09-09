/**
 * Given N and E, the number of nodes and edges in a directed graph. The task is to do Breadth First Search of this graph.
 *
 * Input:
 * The first line of input contains the number of test cases T. For each test case, the first line of input contains N and E separated by space, and next line contains 2*E numbers (E pairs as X Y) are given in the next line which represents an edge from X to Y.
 *
 * Output:
 * For each testcase, print the BFS of the graph starting from 0.
 *
 * Note: The expected output button always produces BFS starting from node 0.
 *
 * User Task:
 * Since, this is a functional problem, your task is to complete the function bfs() which do BFS of the given graph starting from node 0 and prints the nodes in BFS order.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 100
 *
 * Example:
 * Input:
 * 2
 * 5 4
 * 0 1 0 2 0 3 2 4
 * 3 2
 * 0 1 0 2
 *
 * Output:
 * 0 1 2 3 4    // BFS from node 0
 * 0 1 2
 *
 * Explanation:
 * Testcase 1: First line of each test case represent an integer N denoting number of nodes and edges and then in the next line N pairs of values a and b are fed which denotes there is a unidirectional edge from a to b .
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean vis[], int nov) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (!vis[current]) {
                ArrayList<Integer> al = list.get(current);
                System.out.print(current + " ");
                for (int i : al) {
                    if (!vis[i]) queue.add(i);
                }
                vis[current] = true;
            }
        }
    }
}
