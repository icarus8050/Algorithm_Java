package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges (https://leetcode.com/problems/summary-ranges/)
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(Integer.toString(nums[0]));
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];

            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                i++;
            }

            if (a == nums[i]) {
                result.add(Integer.toString(a));
            } else {
                result.add(a + "->" + nums[i]);
            }
        }

        return result;
    }
}
