package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 한수 (https://www.acmicpc.net/submit/1065)
 */
public class BOJ_1065 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (isHansu(i)) {
                answer++;
            }
        }
        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

    private static boolean isHansu(int i) {
        char[] chars = Integer.toString(i).toCharArray();

        if (chars.length <= 2) {
            return true;
        }

        int diff = chars[1] - chars[0];
        for (int j = 2; j < chars.length; j++) {
            if (chars[j] - chars[j - 1] != diff) {
                return false;
            }
        }

        return true;
    }
}
