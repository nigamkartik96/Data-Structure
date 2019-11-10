public class TreeToLinkedList {
    Node root;

    public Node concatenate(Node leftList, Node rightList) {
        if (leftList == null)
            return rightList;
        if (rightList == null)
            return leftList;

        Node leftLast = leftList.left;

        Node rightLast = rightList.left;

        leftLast.right = rightList;
        rightList.left = leftLast;

        leftList.left = rightLast;

        rightLast.right = leftList;

        return leftList;
    }

    public Node bTreeToClist(Node root) {
        if (root == null)
            return null;

        Node left = bTreeToClist(root.left);
        Node right = bTreeToClist(root.right);

        root.left = root.right = root;

        return concatenate(concatenate(left, root), right);
    }
}
