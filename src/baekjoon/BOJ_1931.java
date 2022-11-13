package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 회의실 배정 (https://www.acmicpc.net/problem/1931)
 */
public class BOJ_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Node> nodes = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            nodes.add(new Node(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
        nodes.sort((o1, o2) -> {
            if (o1.e == o2.e) {
                return o1.s - o2.s;
            }
            return o1.e - o2.e;
        });

        int cnt = 0;
        while (!nodes.isEmpty()) {
            Node node = nodes.remove(0);
            while (!nodes.isEmpty() && nodes.get(0).s < node.e) {
                nodes.remove(0);
            }
            cnt++;
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Node {
        int s;
        int e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
