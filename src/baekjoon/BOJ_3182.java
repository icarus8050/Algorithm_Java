package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 한동이는 공부가 하기 싫어! (https://www.acmicpc.net/problem/3182)
 * (나도!)
 */
public class BOJ_3182 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] 선배놈들 = new int[n + 1];
        boolean[] 방문기록 = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            선배놈들[i] = Integer.parseInt(br.readLine());
        }

        int 최대방문횟수 = 0;
        int 가장많은방문가능선배 = -1;
        for (int i = 1; i <= n; i++) {
            int 방문횟수 = dfs(i, 선배놈들, 방문기록);
            if (방문횟수 > 최대방문횟수) {
                최대방문횟수 = 방문횟수;
                가장많은방문가능선배 = i;
            }
            if (가장많은방문가능선배 == 선배놈들.length - 1) {
                break;
            }
        }

        bw.write(가장많은방문가능선배 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dfs(int 시작, int[] 선배놈들, boolean[] 방문기록) {
        if (방문기록[시작]) {
            return 0;
        }
        방문기록[시작] = true;
        int 방문횟수 = dfs(선배놈들[시작], 선배놈들, 방문기록) + 1;
        방문기록[시작] = false;
        return 방문횟수;
    }
}
