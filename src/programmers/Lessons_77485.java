package programmers;

/**
 * 행렬 테투리 회전하기 (https://programmers.co.kr/learn/courses/30/lessons/77485)
 */
public class Lessons_77485 {
    public static void main(String[] args) {
        int[] solution = new Lessons_77485().solution(
                6,
                6,
                new int[][]{
                        {2, 2, 5, 4},
                        {3, 3, 6, 6},
                        {5, 1, 6, 3}
                }
        );
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        int[] answer = new int[queries.length];
        int idx = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = idx++;
            }
        }
        idx = 0;

        for (int[] query : queries) {
            int top = query[0] - 1;
            int left = query[1] - 1;
            int bottom = query[2] - 1;
            int right = query[3] -1;

            int first = matrix[top][left];
            int min = first;
            for (int i = top; i < bottom; i++) {
                int nextValue = matrix[i + 1][left];
                matrix[i][left] = nextValue;
                min = Math.min(min, nextValue);
            }

            for (int i = left; i < right; i++) {
                int nextValue = matrix[bottom][i + 1];
                matrix[bottom][i] = nextValue;
                min = Math.min(min, nextValue);
            }

            for (int i = bottom; i > top; i--) {
                int nextValue = matrix[i - 1][right];
                matrix[i][right] = nextValue;
                min = Math.min(min, nextValue);
            }

            for (int i = right; i > left; i--) {
                int nextValue = matrix[top][i - 1];
                matrix[top][i] = nextValue;
                min = Math.min(min, nextValue);
            }

            matrix[top][left + 1] = first;
            answer[idx++] = min;
        }

        return answer;
    }
}
