package arraysHashing.validSudoku;

import java.util.HashSet;

public class ValidSudoku {

    public static void main(String[] args) {

        ValidSudoku solver = new ValidSudoku();

        char[][] board = {
                {'1','2','.','.','3','.','.','.','.'},
                {'4','.','.','5','.','.','.','.','.'},
                {'.','9','8','.','.','.','.','.','3'},
                {'5','.','.','.','6','.','.','.','4'},
                {'.','.','.','8','.','3','.','.','5'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','4','1','9','.','.','8'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(solver.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {

        HashSet<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {

            for (int c = 0; c < 9; c++) {

                char value = board[r][c];

                if (value == '.') continue;

                String rowKey = value + " in row " + r;
                String colKey = value + " in col " + c;
                String boxKey = value + " in box " + (r/3) + "-" + (c/3);

                if (!seen.add(rowKey) ||
                        !seen.add(colKey) ||
                        !seen.add(boxKey)) {

                    return false;
                }
            }
        }

        return true;
    }
}