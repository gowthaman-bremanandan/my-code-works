package mathgeometry.spiralMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {

        SpiralMatrix solver = new SpiralMatrix();

        int[][] matrix1 = {
                {1,2},
                {3,4}
        };

        System.out.println("Example 1:");
        System.out.println(
                solver.spiralOrder(matrix1)
        ); // [1,2,4,3]

        System.out.println();

        int[][] matrix2 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        System.out.println("Example 2:");
        System.out.println(
                solver.spiralOrder(matrix2)
        ); // [1,2,3,6,9,8,7,4,5]
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {

            // 1️⃣ Left → Right
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // 2️⃣ Top → Bottom
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            // 3️⃣ Right → Left
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // 4️⃣ Bottom → Top
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }

        return result;
    }
}