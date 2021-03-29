package leetcode;

/**
 * 79. Word Search (https://leetcode.com/problems/word-search/)
 */
public class WordSearch {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n, m;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[n][m];
                    visited[i][j] = true;
                    String s = Character.toString(board[i][j]);
                    if (dfs(board, j, i, visited, s, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int x, int y, boolean[][] visited, String current, String target) {
        if (current.length() == target.length()) {
            return current.equals(target);
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((ny >= 0 && ny < n) && (nx >= 0 && nx < m) && !visited[ny][nx]) {
                visited[ny][nx] = true;
                if (dfs(board, nx, ny, visited, current + board[ny][nx], target)) {
                    return true;
                }
                visited[ny][nx] = false;
            }
        }

        return false;
    }

    /*
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }

        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) ||
                search(board, word, i+1, j, index+1) ||
                search(board, word, i, j-1, index+1) ||
                search(board, word, i, j+1, index+1)){
            return true;
        }

        visited[i][j] = false;
        return false;
    }
    */

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(wordSearch.exist(board, "ABCCED"));;
    }
}
