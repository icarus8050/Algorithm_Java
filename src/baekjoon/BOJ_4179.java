package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 불! (https://www.acmicpc.net/problem/4179)
 */
public class BOJ_4179 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int r = Integer.parseInt(inputs[0]);
        int c = Integer.parseInt(inputs[1]);

        final int[] dx = {-1, 0, 1, 0};
        final int[] dy = {0, -1, 0, 1};
        char[][] map = new char[r][c];
        Queue<Pos> fireQueue = new LinkedList<>();
        Queue<Pos> jihoonQueue = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                switch (map[i][j]) {
                    case 'J':
                        jihoonQueue.add(new Pos(j, i, 0));
                        break;
                    case 'F':
                        fireQueue.add(new Pos(j, i, 0));
                        break;
                }
            }
        }
        while (!jihoonQueue.isEmpty()) {
            int fireQueueSize = fireQueue.size();
            int jihoonQueueSize = jihoonQueue.size();
            for (int i = 0; i < fireQueueSize; i++) {
                Pos currentFire = fireQueue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = currentFire.x + dx[j];
                    int nextY = currentFire.y + dy[j];
                    if ((nextX < 0 || nextX >= c) || (nextY < 0 || nextY >= r)) continue;
                    if (map[nextY][nextX] == '#' || map[nextY][nextX] == 'F') continue;
                    map[nextY][nextX] = 'F';
                    fireQueue.add(new Pos(nextX, nextY, currentFire.time + 1));
                }
            }

            for (int i = 0; i < jihoonQueueSize; i++) {
                Pos currentJihoon = jihoonQueue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = currentJihoon.x + dx[j];
                    int nextY = currentJihoon.y + dy[j];
                    if ((nextX < 0 || nextX >= c) || (nextY < 0 || nextY >= r)) {
                        System.out.println(currentJihoon.time + 1);
                        br.close();
                        return;
                    }

                    if (map[nextY][nextX] != '#' && map[nextY][nextX] != 'F' && map[nextY][nextX] != 'J') {
                        jihoonQueue.add(new Pos(nextX, nextY, currentJihoon.time + 1));
                        map[nextY][nextX] = 'J';
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
        br.close();
    }

    private static class Pos {
        int x;
        int y;
        int time;

        public Pos(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
