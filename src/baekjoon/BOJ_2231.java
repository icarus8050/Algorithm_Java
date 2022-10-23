package baekjoon;

import java.io.*;

/**
 * 분해합 (https://www.acmicpc.net/problem/2231)
 */
public class BOJ_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = 0;
        for (int i = 1; i < n; i++) {
            String s = Integer.toString(i);
            int length = s.length();
            int acc = 0;
            for (int j = 0; j < length; j++) {
                acc += s.charAt(j) - '0';
            }
            if (acc + i == n) {
                m = i;
                break;
            }
        }

        bw.write(m + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
