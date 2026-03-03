package dynamicProgramming.twod.longestIncreasingPath;

public class LongestIncreasingPath {

    private int[][] matrix;
    private int[][] dp;
    private int rows;
    private int cols;

    public static void main(String[] args) {

        LongestIncreasingPath solver = new LongestIncreasingPath();

        System.out.println("Example 1:");
        System.out.println(
                solver.longestIncreasingPath(
                        new int[][]{
                                {5,5,3},
                                {2,3,6},
                                {1,1,1}
                        }
                )
        ); // 4

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.longestIncreasingPath(
                        new int[][]{
                                {1,2,3},
                                {2,1,4},
                                {7,6,5}
                        }
                )
        ); // 7
    }

    public int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return 0;

        this.matrix = matrix;
        rows = matrix.length;
        cols = matrix[0].length;

        dp = new int[rows][cols];

        int max = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }

        return max;
    }

    private int dfs(int i, int j) {

        if (dp[i][j] != 0)
            return dp[i][j];

        int max = 1;

        int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        for (int[] dir : directions) {

            int newRow = i + dir[0];
            int newCol = j + dir[1];

            if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    matrix[newRow][newCol] > matrix[i][j]) {

                max = Math.max(
                        max,
                        1 + dfs(newRow, newCol)
                );
            }
        }

        dp[i][j] = max;
        return max;
    }
}