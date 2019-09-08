/**
 * Given an array A[] of integers, sort the array according to frequency of elements. That is elements that have higher frequency come first. If frequencies of two elements are same, then smaller number comes first.
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
 * <p>
 * Output:
 * For each testcase, in a new line, print each sorted array in a seperate line. For each array its numbers should be seperated by space.
 * <p>
 * Constraints:
 * 1 ≤ T ≤ 70
 * 30 ≤ N ≤ 130
 * 1 ≤ Ai ≤ 60
 * <p>
 * Example:
 * Input:
 * 2
 * 5
 * 5 5 4 6 4
 * 5
 * 9 9 9 2 5
 * <p>
 * Output:
 * 4 4 5 5 6
 * 9 9 9 2 5
 * <p>
 * Explanation:
 * Testcase1: The highest frequency here is 2. Both 5 and 4 have that frequency. Now since the frequencies are same then smaller element comes first. So 4 4 comes first then comes 5 5. Finally comes 6.
 * The output is 4 4 5 5 6.
 * <p>
 * Testcase2: The highest frequency here is 3. The element 9 has the highest frequency. So 9 9 9 comes first. Now both 2 and 5 have same frequency. So we print smaller element first.
 * The output is 9 9 9 2 5.
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SortingOnFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            System.out.println(sortByFrequency(arr, n));
        }
    }

    public static StringBuffer sortByFrequency(int arr1[], int l1) {
        Map<Integer, Integer> countMap = getCountMap(arr1, l1);
        StringBuffer result = new StringBuffer();

        countMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .forEach(e -> {
                    int key = e.getKey();
                    int val = e.getValue();
                    for (int i = 0; i < val; i++) {
                        result.append(key + " ");
                    }
                });

        return result;
    }

    private static Map<Integer, Integer> getCountMap(int[] arr, int l1) {
        Map<Integer, Integer> countMap = new LinkedHashMap<>();
        for (int i = 0; i < l1; i++) {
            if (countMap.containsKey(arr[i])) {
                countMap.put(arr[i], countMap.get(arr[i]) + 1);
            } else {
                countMap.put(arr[i], 1);
            }
        }
        return countMap;
    }
}
