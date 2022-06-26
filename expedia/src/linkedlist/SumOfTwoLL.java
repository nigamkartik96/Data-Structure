package linkedlist;

public class SumOfTwoLL {

    static int carry = 0;
    static Node result = null;

    private static void saveToResult(int data) {
        Node node = new Node(data);

        if (result != null) {
            node.next = result;
        }
        result = node;
    }

    private static void sumOfSameLength(Node num1, Node num2) {
        if (num1 == null) return;

        sumOfSameLength(num1.next, num2.next);
        int sum = num1.data + num2.data + carry;
        carry = sum / 10;
        sum = sum % 10;

        saveToResult(sum);
    }

    private static void getSum(Node number1, Node number2) {
        int len1 = Utility.length(number1);
        int len2 = Utility.length(number2);

        if (len1 == len2) {
            sumOfSameLength(number1, number2);
            if (carry != 0) {
                Node node = new Node(carry);
                node.next = result;
                result = node;
            }
        } else {
            if (len1 < len2) {
                Node temp = number1;
                number1 = number2;
                number2 = temp;

                int len = len1;
                len1 = len2;
                len2 = len;
            }
            Node current = number1;
            int diff = len1 - len2;
            while (diff != 0) {
                current = current.next;
                diff--;
            }

            sumOfSameLength(current, number2);
            if (carry != 0) {
                Node node = new Node(carry);
                node.next = result;
                result = node;
            }
        }

//        return null;
    }


    public static void main(String[] args) {
        Node number1 = Utility.getList();
        Node number2 = Utility.getList();
        getSum(number1, number2);
        Utility.printList(result);
    }
}
