package baekjoon;

import java.io.*;

/**
 * 쉬운 계단 수 (https://www.acmicpc.net/problem/10844)
 */
public class BOJ_10844_2 {

    static int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + dp[n][i]) % MOD;
        }
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
