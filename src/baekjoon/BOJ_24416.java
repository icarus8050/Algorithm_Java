package baekjoon;

import java.io.*;

/**
 * 알고리즘 수업 - 피보나치 수 1 (https://www.acmicpc.net/problem/24416)
 */
public class BOJ_24416 {
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        fibo1(n);
        bw.write(count + " ");
        count = 0;
        fibo2(n, new int[n + 1]);
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static int fibo1(int n) {
        if (n == 1 || n == 2) {
            count++;
            return 1;
        }
        return fibo1(n - 1) + fibo1(n - 2);
    }

    public static int fibo2(int n, int[] dp) {
        if (dp[n] != 0) {
            return dp[n];
        }

        if (n == 1 || n == 2) {
            return dp[n] = 1;
        }
        count++;
        return dp[n] = fibo2(n - 1, dp) + fibo2(n - 2, dp);
    }
}
