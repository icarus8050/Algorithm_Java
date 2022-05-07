package leetcode;

/**
 * 283. Move Zeroes (https://leetcode.com/problems/move-zeroes/)
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zeroCnt = 0;
        int[] result = new int[nums.length];
        int idx = 0;

        for (int num : nums) {
            if (num == 0) {
                zeroCnt++;
            } else {
                result[idx++] = num;
            }
        }

        while (zeroCnt != 0) {
            result[idx++] = 0;
            zeroCnt--;
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }
}
