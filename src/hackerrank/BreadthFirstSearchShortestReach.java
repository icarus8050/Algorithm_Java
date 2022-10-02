package hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

/**
 * Breadth First Search: Shortest Reach (https://www.hackerrank.com/challenges/bfsshortreach/problem)
 */
public class BreadthFirstSearchShortestReach {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                ArrayList<Integer>[] edges = new ArrayList[n + 1];
                for (int i = 0; i < edges.length; i++) {
                    edges[i] = new ArrayList<>();
                }

                for (int i = 0; i < m; i++) {
                    String[] edgeInput = bufferedReader.readLine().split(" ");
                    edges[Integer.parseInt(edgeInput[0])].add(Integer.parseInt(edgeInput[1]));
                    edges[Integer.parseInt(edgeInput[1])].add(Integer.parseInt(edgeInput[0]));
                }
                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = bfs(n, m, edges, s);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static List<Integer> bfs(int n, int m, ArrayList<Integer>[] edges, int s) {
        int[] dists = new int[n + 1];
        Arrays.fill(dists, -1);
        dists[s] = 0;
        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            Integer from = queue.poll();

            ArrayList<Integer> edge = edges[from];
            for (Integer to : edge) {
                if (!visited[to]) {
                    visited[to] = true;
                    queue.add(to);
                    dists[to] = dists[from] + 6;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < dists.length; i++) {
            if (dists[i] != 0) {
                result.add(dists[i]);
            }
        }
        return result;
    }
}
