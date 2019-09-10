/**
 * Given a undirected graph, the task is to complete the method isCyclic() to detect if there is a cycle in the undirected graph or not.
 *
 * Input:
 * The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' testcases follow. Each testcase consists of two lines. Description of testcases are as follows: The First line of each testcase contains two integers 'N' and 'M' which denotes the no of vertices and no of edges respectively. The Second line of each test case contains 'M'  space separated pairs u and v denoting that there is a bidirectional  edge from u to v .
 *
 * Output:
 * The method should return 1 if there is a cycle else it should return 0.
 *
 * User task:
 * Since this is a functional problem you don't have to worry about input, you just have to complete the function isCyclic.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N,M <= 100
 * 0 <= u,v <=  N-1
 *
 * Example:
 * Input:
 * 3
 * 2 2
 * 0 1 0 0
 * 4 3
 * 0 1 1 2 2 3
 * 5 4
 * 0 1 2 3 3 4 4 2
 *
 * Output:
 * 1
 * 0
 * 1
 *
 * Explanation:
 * Testcase 1: In above first test case there is a graph with 2 vertices and 2 edges the first edge is from 0 to 1 and other edge is from 0 to 0 .
 * Testcase 2: In the second test case there is a graph with 3 vertices and 3 edges from 0 to 1 , 1 to 2 and 2 to 3.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleUndirectedGraphBFS {
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V) {
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);

        for (int i = 0; i < V; i++)
            if (!visited[i] &&
                    isCyclicConnected(list, i, V, visited))
                return true;
        return false;
    }


    static boolean isCyclicConnected(ArrayList<ArrayList<Integer>> list, int s,
                                     int V, boolean visited[]) {
        int parent[] = new int[V];
        Arrays.fill(parent, -1);
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int i = 0; i < list.get(u).size(); i++) {
                int v = list.get(u).get(i);
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                    parent[v] = u;
                } else if (parent[u] != v)
                    return true;
            }
        }
        return false;
    }
}
