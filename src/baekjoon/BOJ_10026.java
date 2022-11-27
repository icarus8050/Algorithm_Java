package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 적록색약 (https://www.acmicpc.net/problem/10026)
 */
public class BOJ_10026 {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        int 적록색약이아닌사람의구역수 = solve(n, board);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'G') {
                    board[i][j] = 'R';
                }
            }
        }
        int 적록색약인사람의구역수 = solve(n, board);

        bw.write(적록색약이아닌사람의구역수 + " " + 적록색약인사람의구역수 + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    private static int solve(int n, char[][] board) {
        boolean[][] visited = new boolean[n][n];
        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(n, board[i][j], board, visited, j, i);
                    area++;
                }
            }
        }
        return area;
    }

    private static void dfs(int n, char c, char[][] board, boolean[][] visited, int x, int y) {
        if (visited[y][x]) {
            return;
        }
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if ((nx >= 0 && nx < n) && (ny >= 0 && ny < n) && board[ny][nx] == c) {
                dfs(n, c, board, visited, nx, ny);
            }
        }
    }
}
