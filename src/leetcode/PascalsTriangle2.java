package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascals Triangle2 (https://leetcode.com/problems/pascals-triangle-ii/)
 */
public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    row.add(1);
                } else {
                    row.add(answer.get(i - 1).get(j - 1) + answer.get(i - 1).get(j));
                }
            }
            answer.add(row);
        }

        return answer.get(answer.size() - 1);
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            answer.add(1);
            for (int j = i - 1; j > 0; j--) {
                answer.set(j, answer.get(j - 1) + answer.get(j));
            }
        }

        return answer;
    }
}
