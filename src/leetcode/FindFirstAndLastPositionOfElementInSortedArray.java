package leetcode;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int foundTargetIdx = -1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                foundTargetIdx = mid;
                break;
            }

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        start = foundTargetIdx;
        end = foundTargetIdx;
        while (start > 0) {
            if (nums[start - 1] == target) {
                start--;
            } else {
                break;
            }
        }

        while (end < nums.length - 1) {
            if (nums[end + 1] == target) {
                end++;
            } else {
                break;
            }
        }

        return new int[]{start, end};
    }

    /*
    O(n) 으로 풀어본 야매 풀이
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
    */
}
