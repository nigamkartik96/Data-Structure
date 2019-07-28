package linkedlist;

public class ListUtility {
    public static ListNode getList(String value) {
        String arr[] = value.trim().split("\\s");
        ListNode a = new ListNode(Integer.parseInt(arr[0])), head = a;
        for (int i = 1; i < arr.length; i++) {
            a.next = new ListNode(Integer.parseInt(arr[i]));
            a = a.next;
        }

        return head;
    }

    public static int length(ListNode a) {
        int count = 0;
        ListNode head = a;
        while (a != null) {
            count++;
            a = a.next;
        }
        a = head;
        return count;
    }

    public static void traverseList(ListNode a) {
        StringBuilder string = new StringBuilder();
        while (a != null) {
            string.append(a.val + " -> ");
            a = a.next;
        }

        System.out.println(string.substring(0, string.length() - 3).toString());
    }

    static void insert(int a, ListNode A) {
        ListNode ptr1 = A;
        ListNode ptr2 = A.next;
        while(ptr2!=null && a > ptr2.val) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ptr1.next = new ListNode(a);
        ptr1.next.next = ptr2;
    }
}
