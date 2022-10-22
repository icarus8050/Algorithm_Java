package leetcode;

/**
 * 217. Contains Duplicate 2 (https://leetcode.com/problems/contains-duplicate-ii/)
 */
public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length && Math.abs(j - i) <= k; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
