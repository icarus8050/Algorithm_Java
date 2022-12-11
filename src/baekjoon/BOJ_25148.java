package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 정수 a를 k로 만들기 (https://www.acmicpc.net/problem/25418)
 */
public class BOJ_25148 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        int[] dp = new int[k + 1];
        Arrays.fill(dp, 99_999_999);
        dp[a] = 0;
        for (int i = a + 1; i <= k; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        bw.write(dp[k] + "\n");
        bw.close();
        br.close();
    }
}
