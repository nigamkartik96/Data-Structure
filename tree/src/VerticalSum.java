import java.util.Map;
import java.util.TreeMap;

public class VerticalSum {
    public static void printVertical(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        getVerticalSum(map, root, 0);
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.print(e.getValue() + " ");
        }
    }

    private static void getVerticalSum(TreeMap<Integer, Integer> map, Node node, int vertical) {
        if (node == null) return;
        map.put(vertical, map.getOrDefault(vertical, 0) + node.data);

        getVerticalSum(map, node.left, vertical - 1);
        getVerticalSum(map, node.right, vertical + 1);
    }
}
