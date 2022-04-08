package leetcode;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }

        int first = -1;
        int second = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                first = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                second = i;
                break;
            }
        }

        return new int[] {first, second};
    }
}
