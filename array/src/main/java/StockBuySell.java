/**
 * The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.
 *
 * Input:
 * First line contains number of test cases T. First line of each test case contains an integer value N denoting the number of days, followed by an array of stock prices of N days.
 *
 * Output:
 * For each testcase, output all the days with profit in a single line. And if there is no profit then print "No Profit".
 *
 * Constraints:
 * 1 <= T <= 100
 * 2 <= N <= 103
 * 0 <= Ai <= 104
 *
 * Example
 * Input:
 * 2
 * 7
 * 100 180 260 310 40 535 695
 * 10
 * 23 13 25 29 33 19 34 45 65 67
 *
 * Output:
 * (0 3) (4 6)
 * (1 4) (5 9)
 *
 * Explanation:
 * Testcase 1: We can buy stock on day 0, and sell it on 3rd day, which will give us maximum profit.
 *
 * Note: Output format is as follows - (buy_day sell_day) (buy_day sell_day)
 * For each input, output should be in a single line.
 */
public class StockBuySell {
    public static void main(String args[]) {
        StockBuySell obj = new StockBuySell();
        int arr[] = {5, 4, 3, 2, 1};
        System.out.println(obj.getProfitDays(arr));
    }

    public String getProfitDays(int arr[]) {
        StringBuilder str = new StringBuilder();
        int n = arr.length, start = 0, end = 0, profit = 0;
        for (int i = 1; i < n; i++) {
            if (profit < (arr[i] - arr[start])) {
                profit = arr[i] - arr[start];
                end = i;
            } else {
                if (start != end) {
                    str.append("(" + start + " " + end + ") ");
                }
                profit = 0;
                start = end = i;
            }
        }
        if (start != end) {
            str.append("(" + start + " " + end + ")");
        }

        String returnStr = str.toString();
        return returnStr.length() == 0 ? "No Profit" : returnStr;
    }
}
