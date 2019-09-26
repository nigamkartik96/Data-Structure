/* Index  = 0,  1, 2  ,3 ,4  ,5 ,6
    Arr    = {1, 5, 5, 2, 2, -1, 3}

Given an array that represents a tree in such a way that array indexes are values in tree nodes and array values give the parent node of that particular index (or node). The value of the root node index would always be -1 as there is no parent for root. Construct the standard linked representation of given Binary Tree from this given representation



        5
    /      \
    1      2
    /      / \
    0      3  4
          /
          6

*/

public class EmbibeConstructATree {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "[ val = " + this.val + ", left = " + this.left + ", right = " + this.right + " ]";
        }
    }

    public static void main(String args[]) throws Exception {
        int[] arr = {1, 5, 5, 2, 2, -1, 3};
        visited = new boolean[arr.length];
        Node root = new Node(getIndex(-1, arr));
        buildTree(root, arr);
        System.out.println(root);
    }

    static boolean[] visited;

    public static void buildTree(Node node, int[] arr) {
        if (node == null) return;
        int leftIndex = getIndex(node.val, arr);
        System.out.println(leftIndex);
        if (leftIndex == -1) return;
        else {
            visited[leftIndex] = true;
            Node temp = new Node(leftIndex);
            node.left = temp;
        }

        int rightIndex = getIndex(node.val, arr);
        System.out.println(rightIndex);
        if (rightIndex == -1) return;
        else {
            visited[rightIndex] = true;
            Node temp = new Node(rightIndex);
            node.right = temp;
        }

        buildTree(node.left, arr);
        buildTree(node.right, arr);
    }

    public static int getIndex(int val, int arr[]) {
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == val && !visited[i]) {
                break;
            }
        }

        return i == arr.length ? -1 : i;
    }
}

