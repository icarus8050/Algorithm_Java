package leetcode;

/**
 * 45. Jump Game 2 (https://leetcode.com/problems/jump-game-ii/)
 */
public class JumpGame2 {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 999999;
        }

        for (int i = 0; i < nums.length; i++) {
            int jump = nums[i];
            for (int j = 1; j <= jump; j++) {
                if (i + j > nums.length - 1) {
                    break;
                }

                dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
            }
        }

        return dp[nums.length - 1];
    }
}
