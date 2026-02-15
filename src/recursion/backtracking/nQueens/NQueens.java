package recursion.backtracking.nQueens;

import java.util.*;

public class NQueens {

    public static void main(String[] args) {

        System.out.println(solveNQueens(4));
        System.out.println(solveNQueens(1));
    }

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals = new HashSet<>();
        Set<Integer> antiDiagonals = new HashSet<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0, n, board, result, columns, diagonals, antiDiagonals);

        return result;
    }

    private static void backtrack(int row,
                                  int n,
                                  char[][] board,
                                  List<List<String>> result,
                                  Set<Integer> columns,
                                  Set<Integer> diagonals,
                                  Set<Integer> antiDiagonals) {

        if (row == n) {
            result.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {

            int diag = row - col;
            int antiDiag = row + col;

            if (columns.contains(col) ||
                    diagonals.contains(diag) ||
                    antiDiagonals.contains(antiDiag)) {
                continue;
            }

            // Place queen
            board[row][col] = 'Q';
            columns.add(col);
            diagonals.add(diag);
            antiDiagonals.add(antiDiag);

            // Move to next row
            backtrack(row + 1, n, board, result,
                    columns, diagonals, antiDiagonals);

            // Remove queen (Backtrack)
            board[row][col] = '.';
            columns.remove(col);
            diagonals.remove(diag);
            antiDiagonals.remove(antiDiag);
        }
    }

    private static List<String> constructBoard(char[][] board) {

        List<String> result = new ArrayList<>();

        for (char[] row : board) {
            result.add(new String(row));
        }

        return result;
    }
}
