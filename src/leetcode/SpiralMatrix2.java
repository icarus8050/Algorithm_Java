package leetcode;

/**
 * 59. Spiral Matrix II (https://leetcode.com/problems/spiral-matrix-ii/)
 */
public class SpiralMatrix2 {
    public static void main(String[] args) {
        new SpiralMatrix2().generateMatrix(4);
    }
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];

        int i = 1;
        int cnt = n;
        int cx = -1, cy = 0;
        int direction = 0;
        while (i <= n * n) {
            direction %= 4;
            if (direction % 2 == 1) cnt--;
            for (int j = 0; j < cnt; j++) {
                cy += dy[direction];
                cx += dx[direction];
                mat[cy][cx] = i++;
            }
            direction++;
        }

        return mat;
    }
}
