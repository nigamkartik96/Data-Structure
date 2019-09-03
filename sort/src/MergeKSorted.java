/**
 * Given K sorted arrays arranged in form of a matrix. The task is to merge them. You need to complete mergeKArrays() function which takes 2 arguments, an arr[k][k] 2D Matrix containing k sorted arrays and an integer k denoting the number of sorted arrays. The function should return a pointer to the merged sorted arrays.
 *
 * Input:
 * The first line of input contains the number of test cases, then T test cases follows. Each test case will contain an integer N denoting the number of sorted arrays. Then in the next line contains all the elements of the array separated by space.
 *
 * Output:
 * The output will be the sorted merged array.
 *
 * User Task:
 * The task is to complete the function mergeKArrays() which takes two arguments, and returns pointer to the modified array.
 *
 * Constraints:
 * 1 <= T <= 50
 * 1 <= N <= 103
 * 1 <= K <= 10
 *
 * Example:
 * Input:
 * 1
 * 3
 * 1 2 3 4 5 6 7 8 9
 *
 * Output:
 * 1 2 3 4 5 6 7 8 9
 *
 * Explanation:
 * Testcase 1:
 * Above test case has 3 sorted arrays of size 3, 3, 3
 * arr[][] = [[1, 2, 3],
 *
 *              [4, 5, 6],
 *
 *              [7, 8, 9]]
 * The merged list will be [1, 2, 3, 4, 5, 6, 7, 8, 9].
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSorted {
    static class Node {
        int i, j, value;

        Node(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }

        @Override
        public String toString() {
            return "[ value = " + value + "]";
        }
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        for (int i = 0; i < k; i++) {
            queue.add(new Node(i, 0, arr[i][0]));
        }
        int n = arr[0].length;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.j < n - 1) queue.add(new Node(node.i, node.j + 1, arr[node.i][node.j + 1]));
            result.add(node.value);
        }

        return result;
    }


    public static void main(String args[]) {
        int arr[][] = {
                {1, 3, 9},
                {2, 4, 5},
                {6, 7, 8}
        };
        System.out.println(mergeKArrays(arr, 3));
    }
}
