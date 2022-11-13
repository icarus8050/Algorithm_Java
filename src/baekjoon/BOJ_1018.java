package baekjoon;

import java.io.*;

/**
 * 체스판 다시 칠하기 (https://www.acmicpc.net/problem/1018)
 */
public class BOJ_1018 {
    private static String[] whiteStart = {
            "10101010",
            "01010101",
            "10101010",
            "01010101",
            "10101010",
            "01010101",
            "10101010",
            "01010101",
    };
    private static String[] blackStart = {
            "01010101",
            "10101010",
            "01010101",
            "10101010",
            "01010101",
            "10101010",
            "01010101",
            "10101010",
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        String[] board = new String[n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == 'W') {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            }
            board[i] = sb.toString();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                min = Math.min(min, paintBoard(board, i, j));
            }
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int paintBoard(String[] board, int n, int m) {
        int whiteStartCnt = 0;
        int blackStartCnt = 0;
        for (int i = n; i < n + 8; i++) {
            String row = board[i].substring(m, m + 8);
            String rowWhite = whiteStart[i % 8];
            String rowBlack = blackStart[i % 8];
            for (int j = 0; j < 8; j++) {
                if (row.charAt(j) != rowWhite.charAt(j)) {
                    whiteStartCnt++;
                }
                if (row.charAt(j) != rowBlack.charAt(j)) {
                    blackStartCnt++;
                }
            }
        }
        return Math.min(whiteStartCnt, blackStartCnt);
    }
}
