package leetcode;

/**
 * 96. Unique Binary Search Trees (https://leetcode.com/problems/unique-binary-search-trees/)
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i / 2; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
            dp[i] *= 2;

            if (i % 2 == 1) {
                dp[i] += dp[i / 2] *  dp[i / 2];
            }
        }
        return dp[n];
    }
}
