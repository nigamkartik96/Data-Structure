import java.util.Scanner;

public class StringPNC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            int n = sc.nextInt();
            int val = 1 + (n * 2) + (n * ((n * n) - 1) / 2);
            System.out.println(val);
        }
    }
}
