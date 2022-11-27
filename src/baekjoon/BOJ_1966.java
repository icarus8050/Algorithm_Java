package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 프린터 큐 (https://www.acmicpc.net/problem/1966)
 */
public class BOJ_1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        String[] inputs;
        while (t-- > 0) {
            inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);

            PriorityQueue<Node> priQueue = new PriorityQueue<>(Comparator.comparing(node -> node.pri, (o1, o2) -> o2 - o1));
            Queue<Node> queue = new LinkedList<>();
            inputs = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                Node node = new Node(i, Integer.parseInt(inputs[i]));
                queue.offer(node);
                priQueue.offer(node);
            }

            int seq = 0;
            while (!queue.isEmpty()) {
                seq++;
                while (queue.peek().pri < priQueue.peek().pri) {
                    queue.offer(queue.poll());
                }
                Node node = queue.poll();
                priQueue.poll();
                if (node.idx == m) {
                    break;
                }
            }
            bw.write(seq + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Node {
        public int idx;

        public int pri;

        public Node(int idx, int pri) {
            this.idx = idx;
            this.pri = pri;
        }
    }
}
