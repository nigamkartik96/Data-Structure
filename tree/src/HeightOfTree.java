public class HeightOfTree {
    class Node {
        Node left, right;
        int data;

        Node(int data) {
            left = right = null;
            this.data = data;
        }
    }

    public int height(Node node) {
        if (node == null) return 0;
        else {
            int left = height(node.left);
            int right = height(node.right);

            if (left > right) return left + 1;
            else return right + 1;
        }
    }
}
