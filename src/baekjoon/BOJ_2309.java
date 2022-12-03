package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * 일곱 난쟁이 (https://www.acmicpc.net/problem/2309)
 */
public class BOJ_2309 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] 키큰난쟁이들 = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            키큰난쟁이들[i] = Integer.parseInt(br.readLine());
            sum += 키큰난쟁이들[i];
        }
        solve(sum, 키큰난쟁이들);
        Arrays.sort(키큰난쟁이들);

        for (int i = 2; i < 9; i++) {
            bw.write(키큰난쟁이들[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(int sum, int[] 키큰난쟁이들) {
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - (키큰난쟁이들[i] + 키큰난쟁이들[j]) == 100) {
                    키큰난쟁이들[i] = 0;
                    키큰난쟁이들[j] = 0;
                    return;
                }
            }
        }
    }
}
