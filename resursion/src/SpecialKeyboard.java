import java.util.Scanner;

public class SpecialKeyboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            int n = sc.nextInt();
            System.out.println(getLength(n, 0, 0));
        }
    }

    public static int getLength(int n, int len, int buffer) {
        int key2 = 0, key1, key4;
        if (n <= 0) return len;

        key1 = getLength(n - 1, len + 1, buffer);
        if (n >= 3)
            key2 = getLength(n - 3, len * 2, len);
        key4 = getLength(n - 1, len + buffer, buffer);

        int result = key1 > key2 ? key1 : key2;
        result = key4 > result ? key4 : result;

        return result;
    }
}
