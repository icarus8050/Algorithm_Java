package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 부녀회장이 될테니 (https://www.acmicpc.net/problem/2775)
 */
public class BOJ_2775_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] apt = new int[k + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                apt[0][i] = i;
            }

            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    apt[i][j] = apt[i - 1][j] + apt[i][j - 1];
                }
            }
            bw.write(apt[k][n] + "\n");
        }
        br.close();
        bw.close();
    }
}
