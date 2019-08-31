public class Node {
    Node prev;
    Node next;
    int data;

    Node(int data) {
        prev = null;
        next = null;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }
}
