package baekjoon;

import java.io.*;

/**
 * 영화감독 슘 (https://www.acmicpc.net/problem/1436)
 */
public class BOJ_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            bw.write("666\n");
        } else {
            int m = 666;
            int c = 1;
            while (c != n) {
                while (true) {
                    m++;
                    String s = Integer.toString(m);
                    if (s.contains("666")) {
                        break;
                    }
                }
                c++;
            }
            bw.write(m + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
