package mathgeometry.rotateImage;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {

        RotateImage solver = new RotateImage();

        int[][] matrix1 = {
                {1,2},
                {3,4}
        };

        solver.rotate(matrix1);
        printMatrix(matrix1);
        // [[3,1],[4,2]]

        System.out.println();

        int[][] matrix2 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        solver.rotate(matrix2);
        printMatrix(matrix2);
        // [[7,4,1],[8,5,2],[9,6,3]]
    }

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}