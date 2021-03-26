package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets (https://leetcode.com/problems/subsets/)
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        recursive(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    private void recursive(int[] nums, int cur, List<List<Integer>> ans, List<Integer> arr) {

        for (int i = cur; i < nums.length; i++) {
            arr.add(nums[i]);
            ans.add(new ArrayList<>(arr));
            recursive(nums, i + 1, ans, arr);
            arr.remove(arr.size() - 1);
        }
    }
}
