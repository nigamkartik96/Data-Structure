import java.util.LinkedList;
import java.util.Queue;

public class ConnectSameLevel {
    static class Level {
        Node node;
        int level;

        Level(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    static void connect(Node node) {
        if (node == null || (node.right == null && node.left == null)) return;

        Queue<Level> q = new LinkedList<>();
        Level l = new Level(node, 0);
        q.add(l);

        while (!q.isEmpty()) {
            l = q.poll();
            if (l.node.left != null) {
                q.add(new Level(l.node.left, l.level + 1));
            }

            if (l.node.right != null) {
                q.add(new Level(l.node.right, l.level + 1));
            }

            if (!q.isEmpty() && q.peek().level == l.level) {
                l.node.nextRight = q.peek().node;
            } else {
                l.node.nextRight = null;
            }
        }
    }
}
