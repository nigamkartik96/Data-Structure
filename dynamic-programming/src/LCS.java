import java.util.HashMap;
import java.util.Map;

class LCS {
    static class Set {
        int i, j;
        private int hashCode;

        Set(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Set that = (Set) o;
            return i == that.i && j == that.j;
        }

        @Override
        public int hashCode() {
            return this.hashCode;
        }
    }

    static Map<Set, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(lcsRecursion("bd", "abcd", 0, 0));
        memo = new HashMap<>();
        System.out.println(lcsRecursion("absfel", "ammbois f kmk e l", 0, 0));


        System.out.println(lcsTabulation("bd", "abcd"));
        System.out.println(lcsTabulation("absfel", "ammbois f kmk e l"));
    }

    static int lcsRecursion(String a, String b, int i, int j) {
        if (a == null || b == null) {
            return 0;
        }
        if (a.length() <= i || b.length() <= j) {
            return 0;
        }
        Set set = new Set(i, j);
        if (memo.containsKey(set)) {
            return memo.get(set);
        }

        if (a.charAt(i) == b.charAt(j)) {
            memo.put(set, 1 + lcsRecursion(a, b, i + 1, j + 1));
            return memo.get(set);
        }

        memo.put(set, Math.max(lcsRecursion(a, b, i + 1, j), lcsRecursion(a, b, i, j + 1)));
        return memo.get(set);
    }

    static int lcsTabulation(String a, String b) {
        if (a == null || b == null) {
            return 0;
        }
        if (a.isEmpty() || b.isEmpty()) {
            return 0;
        }
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= b.length(); i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[a.length()][b.length()];
    }
}