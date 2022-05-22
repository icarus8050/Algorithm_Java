package leetcode;

/**
 * 74. Search a 2D Matrix (https://leetcode.com/problems/search-a-2d-matrix/)
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = 0;

        while (matrix.length > m &&
                matrix[m][matrix[m].length - 1] < target) {
            m += 1;
        }

        for (int i = 0; matrix.length > m && i < matrix[m].length; i++) {
            if (matrix[m][i] == target) {
                return true;
            }
        }

        return false;
    }
}
