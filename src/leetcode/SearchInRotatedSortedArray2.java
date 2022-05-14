package leetcode;

/**
 * 81. Search in Rotated Sorted Array II (https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)
 */
public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int mid = (s + e) / 2;

            if (nums[mid] == target) return true;

            if (nums[mid] > nums[s]) {
                if (nums[mid] > target && nums[s] <= target) e = mid - 1;
                else s = mid + 1;
            } else if (nums[mid] < nums[s]) {
                if (nums[mid] < target && nums[s] > target) s = mid + 1;
                else e = mid - 1;
            } else {
                s++;
            }
        }

        return false;
    }
}
