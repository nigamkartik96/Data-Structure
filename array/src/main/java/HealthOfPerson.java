import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HealthOfPerson {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        StringBuffer s = new StringBuffer();
        while (testCases-- != 0) {
            String s1[] = br.readLine().split(" ");
            String s2[] = br.readLine().split(" ");
            String s3[] = br.readLine().split(" ");
            int n = Integer.parseInt(s1[0]), m = Integer.parseInt(s1[1]);
            int healths[] = new int[n + 1], res[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                healths[i] = Integer.parseInt(s2[i - 1]);
            }
            for (int i = 1; i <= m; i++) {
                int day = Integer.parseInt(s3[i - 1]);
                for (int j = i; j <= n; j += i)
                    if (res[j] == 0 && healths[j] - day <= 0) res[j] = i;
            }

            for (int i = 1; i <= n; i++) {
                if (res[i] == 0) s.append(-1 + "\n");
                else s.append(res[i] + "\n");

            }
        }
        System.out.println(s.toString());
    }
}
