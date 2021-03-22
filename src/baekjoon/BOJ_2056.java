package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

import static java.lang.Math.*;

/**
 * 작업 (https://www.acmicpc.net/problem/2056)
 */
public class BOJ_2056 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] inDegree = new int[n + 1];
        int[] works = new int[n + 1];
        int[] endTime = new int[n + 1];
        int result = 0;
        List<Integer>[] adjList = new ArrayList[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            works[i] = Integer.parseInt(st.nextToken());

            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int preJob = Integer.parseInt(st.nextToken());
                adjList[preJob].add(i);
                inDegree[i]++;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                endTime[i] = works[i];
            }
        }

        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            for (Integer nextNode : adjList[node]) {
                if (--inDegree[nextNode] == 0) {
                    queue.add(nextNode);
                }

                endTime[nextNode] = max(endTime[nextNode], endTime[node] + works[nextNode]);
            }
        }

        for (int i = 1; i <= n; i++) {
            result = max(result, endTime[i]);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
