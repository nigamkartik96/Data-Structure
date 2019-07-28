/**
 * Sort a linked list using insertion sort.
 * <p>
 * We have explained Insertion Sort at Slide 7 of Arrays
 * <p>
 * Insertion Sort Wiki has some details on Insertion Sort as well.
 * <p>
 * Example :
 * <p>
 * Input : 1 -> 3 -> 2
 * <p>
 * Return 1 -> 2 -> 3
 */
package linkedlist;

public class InsertionSort {

    public ListNode insertionSortList(ListNode A) {
        ListNode sortedList = new ListNode(-11000000);

        while (A != null) {
            ListUtility.insert(A.val, sortedList);
            A = A.next;
        }

        return sortedList.next;
    }


    public static void main(String args[]) {
        InsertionSort obj = new InsertionSort();
        ListNode node = ListUtility.getList("5 4 3 2 1");
        node = obj.insertionSortList(node);
        ListUtility.traverseList(node);
    }
}
