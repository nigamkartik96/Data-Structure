import java.util.Scanner;

public class DistributionOfToys {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            long ans = 0;
            for (int i = 1; i < n; i++) {
                int req = n - i;
                for (int j = 1; j < i; j++) {
                    int k = req - j;
                    if (k > 0 && k < i) {
                        ans += 3;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
