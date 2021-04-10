package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. Triangle (https://leetcode.com/problems/triangle/)
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[1][1] = triangle.get(0).get(0);

        for (int i = 2; i <= n; i++) {
            List<Integer> cols = triangle.get(i - 1);
            int size = cols.size();
            for (int j = 1; j <= size; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + cols.get(j - 1);
            }
        }

        int ans = dp[n][1];
        for (int i = 2; i <= n; i++) {
            ans = Math.min(dp[n][i], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new Triangle().minimumTotal(triangle));
    }
}
