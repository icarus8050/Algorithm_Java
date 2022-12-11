package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 설탕배달 (https://www.acmicpc.net/problem/2839)
 */
public class BOJ_2839 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int max = 99_999_999;
        Arrays.fill(dp, max);
        dp[3] = 1;
        if (n >= 5) {
            dp[5] = 1;
        }
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            if (i >= 5) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }

        if (dp[n] == max) {
            bw.write("-1\n");
        } else {
            bw.write(dp[n] + "\n");
        }

        br.close();
        bw.close();
    }
}
