package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle (https://leetcode.com/problems/pascals-triangle/)
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        int[][] arr = new int[numRows][numRows];
        arr[0][0] = 1;
        List<Integer> initArray = new ArrayList<>();
        initArray.add(arr[0][0]);
        answer.add(initArray);

        for (int i = 1; i < numRows; i++) {
            answer.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                int upLeft = 0;
                int upRight = 0;

                if (isAvailableLocation(i - 1, j - 1, numRows)) {
                    upLeft = arr[i - 1][j - 1];
                }

                if (isAvailableLocation(i - 1, j, numRows)) {
                    upRight = arr[i - 1][j];
                }
                arr[i][j] = upLeft + upRight;
                answer.get(i).add(arr[i][j]);
            }
        }
        return answer;
    }

    private boolean isAvailableLocation(int i, int j, int numRows) {
        return (i >= 0 && i < numRows) && (j >= 0 && j < numRows);
    }
}
