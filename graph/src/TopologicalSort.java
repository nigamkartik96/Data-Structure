/**
 * Given a directed graph, you need to complete the function topoSort which returns an array having the topologically sorted elements of the array and takes two arguments. The first argument is the Graph graph represented as adjacency list and the second is the number of vertices N.
 *
 * Note : There can be multiple topological sorts of a Graph.  The driver program that calls your function doesn't match your output element by element, but checks whether the output produced by your function is a valid topological sort or not.
 *
 * Input:
 * The first line of input takes the number of test cases then T test cases follow . Each test case contains two lines. The first  line of each test case  contains two integers E and N representing no of edges and the number of vertices. Then in the next line are E  pairs of integers u, v representing an edge from u to v in the graph.
 *
 * Output:
 * For each test case output will be 1 if the topological sort is done correctly else it will be 0 .
 *
 * Constraints:
 * 1 <= T <= 50
 * 1 <= E, N <= 50
 * 0 <= u, v
 *
 * Example:
 * Input
 * 2
 * 6 6
 * 5 0 5 2 2 3 4 0 4 1 1 3
 * 4 4
 * 3 0 1 0 2 0 0 1
 *
 * Output:
 * 1
 * 0
 *
 * Explanation:
 * Testcase 1: The output 1 denotes that the order is valid.  So, if you have implemented your function correctly, then output would be 1 for all test cases.
 */

import java.util.ArrayList;
import java.util.Stack;

class TopologicalSort {
    static int[] topoSort(ArrayList<ArrayList<Integer>> list, int n) {
        Stack<Integer> stack = new Stack<>();
        boolean vis[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) topoUtil(i, vis, stack, list);
        }
        int arr[] = new int[n];
        int k = n - 1;
        while (!stack.isEmpty()) {
            arr[k] = stack.pop();
            k--;
        }
        return arr;
    }

    static void topoUtil(int v, boolean[] vis, Stack<Integer> stack, ArrayList<ArrayList<Integer>> list) {
        vis[v] = true;
        ArrayList<Integer> al = list.get(v);
        for (int i : al) {
            if (!vis[i]) topoUtil(i, vis, stack, list);
        }
        stack.push(v);
    }

}