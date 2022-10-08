package baekjoon;

import java.io.*;

import static java.lang.Math.*;

/**
 * RGB 거리 (https://www.acmicpc.net/problem/1149)
 */
public class BOJ_1149 {
    public static int RED = 0;
    public static int GREEN = 1;
    public static int BLUE = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][3];
        int[][] rgbCost = new int[n + 1][3];
        for (int i = 1; i < n + 1; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                rgbCost[i][j] = Integer.parseInt(input[j]);
            }
        }
        dp[1][RED] = rgbCost[1][RED];
        dp[1][GREEN] = rgbCost[1][GREEN];
        dp[1][BLUE] = rgbCost[1][BLUE];
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][RED] = rgbCost[i][RED] + min(dp[i -1][GREEN], dp[i - 1][BLUE]);
                dp[i][GREEN] = rgbCost[i][GREEN] + min(dp[i - 1][RED], dp[i - 1][BLUE]);
                dp[i][BLUE] = rgbCost[i][BLUE] + min(dp[i - 1][RED], dp[i - 1][GREEN]);
            }
        }

        bw.write(min(dp[n][RED], min(dp[n][GREEN], dp[n][BLUE])) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
