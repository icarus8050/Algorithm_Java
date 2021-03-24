package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval (https://leetcode.com/problems/insert-interval/)
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int[] currentInterval = newInterval;

        for (int[] interval : intervals) {
            if (interval[1] < currentInterval[0]) {
                ans.add(interval);
            } else if (interval[0] > currentInterval[1]) {
                ans.add(currentInterval);
                currentInterval = interval;
            } else {
                currentInterval = new int[]{
                        Math.min(interval[0], currentInterval[0]),
                        Math.max(interval[1], currentInterval[1])
                };
            }
        }

        ans.add(currentInterval);
        return ans.toArray(new int[ans.size()][2]);
    }
}
