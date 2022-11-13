package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * 점프 점프 (https://www.acmicpc.net/problem/14248)
 */
public class BOJ_14248 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] rocks = new int[n];
        boolean[] visited = new boolean[n];
        Set<Integer> visitLog = new HashSet<>();

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < rocks.length; i++) {
            rocks[i] = Integer.parseInt(input[i]);
        }
        int start = Integer.parseInt(br.readLine()) - 1;
        dfs(start, rocks, visited, visitLog);
        bw.write(visitLog.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start, int[] rocks, boolean[] visited, Set<Integer> visitLog) {
        if (visited[start]) {
            return;
        }
        visitLog.add(start);
        visited[start] = true;
        if (start + rocks[start] < rocks.length) {
            dfs(start + rocks[start], rocks, visited, visitLog);
        }
        if (start - rocks[start] >= 0) {
            dfs(start - rocks[start], rocks, visited, visitLog);
        }
        visited[start] = false;
    }
}
