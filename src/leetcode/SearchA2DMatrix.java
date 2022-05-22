package leetcode;

/**
 * 74. Search a 2D Matrix (https://leetcode.com/problems/search-a-2d-matrix/)
 */
public class SearchA2DMatrix {
    /*
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
    */

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            else if (matrix[i][j] > target) {
                j--;
            }
            else if (matrix[i][j] < target) {
                i++;
            }
        }
        return false;
    }
}
