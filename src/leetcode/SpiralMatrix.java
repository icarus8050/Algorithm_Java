package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix (https://leetcode.com/problems/spiral-matrix/)
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    static int[]d  = {1, 1, -1, -1};
    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int len = n * m;
        List<Integer> spiral = new ArrayList<>();

        int readN = n - 1;
        int readM = m;
        int curX = 0;
        int curY = 0;
        int nd = 0;
        while (spiral.size() != len) {
            if (nd == 0 || nd == 2) {
                for (int i = 0; i < readM; i++) {
                    spiral.add(matrix[curY][curX]);
                    curX += d[nd];
                }
                readM--;
                curX += -d[nd];
                if (nd == 0) {
                    curY++;
                } else {
                    curY--;
                }
            } else {
                for (int i = 0; i < readN; i++) {
                    spiral.add(matrix[curY][curX]);
                    curY += d[nd];
                }
                readN--;
                curY += -d[nd];
                if (nd == 1) {
                    curX--;
                } else {
                    curX++;
                }
            }

            nd++;
            nd %= 4;
        }

        return spiral;
    }
}
