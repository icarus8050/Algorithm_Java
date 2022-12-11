package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 지능형 기차2 (https://www.acmicpc.net/problem/2460)
 */
public class BOJ_2460 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0;
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            String[] inputs = br.readLine().split(" ");
            int in = Integer.parseInt(inputs[0]);
            int out = Integer.parseInt(inputs[1]);
            cnt -= in;
            cnt += out;
            max = Math.max(max, cnt);
        }
        bw.write(max + "\n");
        br.close();
        bw.close();
    }
}
