package linkedlist;

public class ListUtility {
    public ListNode getList(String value) {
        String arr[] = value.split("\\s");
        ListNode a = new ListNode(Integer.parseInt(arr[0])), head = a;
        for (int i = 1; i < arr.length; i++) {
            a.next = new ListNode(Integer.parseInt(arr[i]));
            a = a.next;
        }

        return head;
    }

    public int length(ListNode a) {
        int count = 0;
        ListNode head = a;
        while (a != null) {
            count++;
            a = a.next;
        }
        a = head;
        return count;
    }
}
