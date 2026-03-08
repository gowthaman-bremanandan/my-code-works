package mathgeometry.setMatrixZeroes;

import java.util.Arrays;

public class SetMatrixZeroes {

    public static void main(String[] args) {

        SetMatrixZeroes solver = new SetMatrixZeroes();

        int[][] matrix1 = {
                {0,1},
                {1,0}
        };

        solver.setZeroes(matrix1);
        print(matrix1);
        // [[0,0],[0,0]]

        System.out.println();

        int[][] matrix2 = {
                {1,2,3},
                {4,0,5},
                {6,7,8}
        };

        solver.setZeroes(matrix2);
        print(matrix2);
        // [[1,0,3],[0,0,0],[6,0,8]]
    }

    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstColZero = false;

        // Step 1: Mark rows and columns
        for (int i = 0; i < m; i++) {

            if (matrix[i][0] == 0)
                firstColZero = true;

            for (int j = 1; j < n; j++) {

                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 2: Apply markers (bottom-up)
        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 1; j--) {

                if (matrix[i][0] == 0 ||
                        matrix[0][j] == 0) {

                    matrix[i][j] = 0;
                }
            }

            if (firstColZero) {
                matrix[i][0] = 0;
            }
        }
    }

    private static void print(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}