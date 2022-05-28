package leetcode;

/**
 * 80. Remove Duplicates from Sorted Array II (https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)
 */
public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int num : nums) {
            if (k < 2 || num > nums[k - 2]) {
                nums[k++] = num;
            }
        }
        return k;
    }
}
