package leetcode;

/**
 * 136. Single Number (https://leetcode.com/problems/single-number/)
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
