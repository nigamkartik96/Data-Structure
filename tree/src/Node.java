public class Node {
    Node left, right, nextRight;
    int data;

    Node(int data) {
        nextRight = left = right = null;
        this.data = data;
    }
}
