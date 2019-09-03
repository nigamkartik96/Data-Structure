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
