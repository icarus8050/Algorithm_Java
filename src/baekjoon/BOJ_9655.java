package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 돌 게임 (https://www.acmicpc.net/problem/9655)
 */
public class BOJ_9655 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 0) {
            bw.write("CY\n");
        } else {
            bw.write("SK\n");
        }
        bw.close();
        bw.close();
    }
}
