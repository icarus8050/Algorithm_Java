package leetcode;

/**
 * 64. Minimum Path Sum (https://leetcode.com/problems/minimum-path-sum/)
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = grid[0][0];

        for (int i = 0; i < m; i++) {
            dp[1][i + 1] = dp[1][i] + grid[0][i];
        }

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1000;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i + 1][j + 1] = grid[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
            }
        }

        return dp[n][m];
    }
}
