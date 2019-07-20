/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * <p>
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
 * <p>
 * Example 2:
 * <p>
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
 * <p>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * <p>
 * Make sure the returned intervals are also sorted.
 */
package array;

import java.util.ArrayList;
import java.util.Collections;

public class MergeIntervals {

    class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "{" + this.start + ", " + this.end + "}";
        }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        Collections.sort(intervals, (e1, e2) -> e1.start < e2.start ? -1 : 1);

        ArrayList<Interval> list = new ArrayList<>();
        int k = 0;
        list.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval currentInterval = intervals.get(i);
            if (list.get(k).end > currentInterval.start) {
                list.get(k).end = Math.max(currentInterval.end, list.get(k).end);
            } else {
                list.add(currentInterval);
                k++;
            }
        }

        return list;
    }

    public ArrayList<Interval> returnList() {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 2));
        list.add(new Interval(3, 5));
        list.add(new Interval(6, 7));
        list.add(new Interval(8, 10));
        list.add(new Interval(12, 16));

        return list;
    }

    public Interval returnInterval(int a, int b) {
        return new Interval(a, b);
    }

    public static void main(String args[]) {
        MergeIntervals obj = new MergeIntervals();
        System.out.println(obj.insert(obj.returnList(), obj.returnInterval(4, 9)));
    }
}
