package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 73. Set Matrix Zero (https://leetcode.com/problems/set-matrix-zeroes/)
 */
public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new Node(j, i));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            setZero(matrix, node);
        }
    }

    private void setZero(int[][] matrix, Node node) {
        for (int k = 0; k < matrix.length; k++) {
            matrix[k][node.x] = 0;
        }

        for (int k = 0; k < matrix[node.y].length; k++) {
            matrix[node.y][k] = 0;
        }
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
