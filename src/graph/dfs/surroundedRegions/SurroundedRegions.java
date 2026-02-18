package graph.dfs.surroundedRegions;

public class SurroundedRegions {

    public static void main(String[] args) {

        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','O','O','X'},
                {'X','X','X','O'}
        };

        solve(board);
        print(board);
    }

    public static void solve(char[][] board) {

        if (board == null || board.length == 0)
            return;

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Mark border-connected O's
        for (int r = 0; r < rows; r++) {
            dfs(board, r, 0);
            dfs(board, r, cols - 1);
        }

        for (int c = 0; c < cols; c++) {
            dfs(board, 0, c);
            dfs(board, rows - 1, c);
        }

        // Step 2 & 3: Flip surrounded O's and restore safe ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }

                if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private static void dfs(char[][] board, int r, int c) {

        if (r < 0 || c < 0 ||
                r >= board.length || c >= board[0].length ||
                board[r][c] != 'O') {
            return;
        }

        board[r][c] = 'T';

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }

    private static void print(char[][] board) {
        for (char[] row : board) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}
