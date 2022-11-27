package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 더하기 싸이클 (https://www.acmicpc.net/problem/1110)
 */
public class BOJ_1110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int origin = n;
        int cycle = 0;
        do {
            cycle++;
            int i = (origin / 10) + (origin % 10);
            origin = (origin % 10 * 10) + (i % 10);
        } while (n != origin);

        bw.write(cycle + "\n");
        bw.flush();
        br.close();
        br.close();
    }
}
