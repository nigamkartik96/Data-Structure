/**
 * In operating systems that use paging for memory management, page replacement algorithm are needed to decide which page needs to be replaced when the new page comes in. Whenever a new page is referred and is not present in memory, the page fault occurs and Operating System replaces one of the existing pages with a newly needed page. Given a sequence of pages and memory capacity, your task is to find the number of page faults using Least Recently Used (LRU) Algorithm.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Each test case contains n number of pages and next line contains space seaprated sequence of pages. The following line consist of the capacity of the memory.
 * Note: Pages are referred in the order left to right from the array (i.e index 0 page is referred first then index 1 and so on). Memory is empty at the start.
 *
 * Output:
 * Output the number of page faults.
 *
 * Constraints:
 * 1<=T<=100
 * 1<=n<=1000
 * 4<=capacity<=100
 *
 * Example:
 * Input:
 * 2
 * 9
 * 5 0 1 3 2 4 1 0 5
 * 4
 * 8
 * 3 1 0 2 5 4 1 2
 * 4
 *
 * Output:
 * 8
 * 7
 *
 * Explanation:
 * Testcase 1:
 * memory allocated with 4 pages 5, 0, 1, 3: page fault = 4
 * page number 2 is required, replaces LRU 5: page fault = 4+1 = 5
 * page number 4 is required, replaces LRU 0: page fault = 5 + 1 = 6
 * page number 1 is required which is already present: page fault = 6 + 0 = 6
 * page number 0 is required which replaces LRU 1: page fault = 6 + 1 = 7
 * page number 5 is required which replaces LRU 3: page fault = 7 + 1  =8.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PageFaults {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int size = sc.nextInt();

            System.out.println(getPageFaults(arr, size, n));
        }
    }

    private static int getPageFaults(int[] pages, int capacity, int n) {
	     /*ArrayList<Integer> lru = new ArrayList<>();
	     lru.add(arr[0]);
	     int pageFaults = 1;
	     for (int i = 1; i < size && i < n; i++) {
	         if (lru.contains(arr[i])) {
	             lru.remove(Integer.valueOf(arr[i]));
	             lru.add(arr[i]);
	         } else {
                lru.add(arr[i]);
                pageFaults++;
	         }
	     }

	     for(int i = size; i < n; i++) {
	         if (lru.contains(arr[i])) {
	             lru.remove(Integer.valueOf(arr[i]));
	             lru.add(arr[i]);
	         } else {
                lru.remove(0);
                lru.add(arr[i]);
                pageFaults++;
	         }
	     }

	     return pageFaults;*/

        HashSet<Integer> s = new HashSet<>(capacity);
        HashMap<Integer, Integer> indexes = new HashMap<>();

        int pageFaults = 0;
        for (int i = 0; i < n; i++) {
            if (s.size() < capacity) {
                if (!s.contains(pages[i])) {
                    s.add(pages[i]);

                    pageFaults++;
                }

                indexes.put(pages[i], i);
            }

            else {
                if (!s.contains(pages[i])) {
                    int lru = Integer.MAX_VALUE, val = Integer.MIN_VALUE;

                    Iterator<Integer> itr = s.iterator();

                    while (itr.hasNext()) {
                        int temp = itr.next();
                        if (indexes.get(temp) < lru) {
                            lru = indexes.get(temp);
                            val = temp;
                        }
                    }

                    s.remove(val);
                    indexes.remove(val);
                    s.add(pages[i]);

                    pageFaults++;
                }

                indexes.put(pages[i], i);
            }
        }
        return pageFaults;
    }
}
