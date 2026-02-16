package recursion.backtracking.wordSearch;

public class WordSearch {

    public static void main(String[] args) {

        char[][] board = {
                {'A','B','C','D'},
                {'S','A','A','T'},
                {'A','C','A','E'}
        };

        System.out.println(exist(board, "CAT")); // true
        System.out.println(exist(board, "BAT")); // false
    }

    public static boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board,
                               String word,
                               int r,
                               int c,
                               int index) {

        // If full word matched
        if (index == word.length()) {
            return true;
        }

        // Out of bounds
        if (r < 0 || c < 0 ||
                r >= board.length || c >= board[0].length) {
            return false;
        }

        // Character mismatch
        if (board[r][c] != word.charAt(index)) {
            return false;
        }

        // Mark as visited
        char temp = board[r][c];
        board[r][c] = '#';

        // Explore 4 directions
        boolean found =
                dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1);

        // Restore
        board[r][c] = temp;

        return found;
    }
}
