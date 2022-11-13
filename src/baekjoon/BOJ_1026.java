package baekjoon;

import java.io.*;
import java.util.Arrays;

/**
 * 보물 (https://www.acmicpc.net/problem/1026)
 */
public class BOJ_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        int s = 0;
        String[] inputA = br.readLine().split(" ");
        String[] inputB = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(inputA[i]);
            b[i] = Integer.parseInt(inputB[i]);
        }
        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < n; i++) {
            s += a[i] * b[n - i - 1];
        }

        bw.write(s + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
