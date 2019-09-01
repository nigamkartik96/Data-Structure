public class ListUtility {
    public static Node getList(String value) {
        String arr[] = value.trim().split("\\s");
        Node a = new Node(Integer.parseInt(arr[0])), head = a;
        for (int i = 1; i < arr.length; i++) {
            a.next = new Node(Integer.parseInt(arr[i]));
            a = a.next;
        }

        return head;
    }

    public static int length(Node a) {
        int count = 0;
        Node head = a;
        while (a != null) {
            count++;
            a = a.next;
        }
        a = head;
        return count;
    }

    public static void traverseList(Node a) {
        StringBuilder string = new StringBuilder();
        while (a != null) {
            string.append(a.data + " -> ");
            a = a.next;
        }

        System.out.println(string.substring(0, string.length() - 3).toString());
    }

    static void insert(int a, Node A) {
        Node ptr1 = A;
        Node ptr2 = A.next;
        while (ptr2 != null && a > ptr2.data) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ptr1.next = new Node(a);
        ptr1.next.next = ptr2;
    }
}
