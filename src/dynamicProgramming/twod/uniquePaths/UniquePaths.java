package dynamicProgramming.twod.uniquePaths;

public class UniquePaths {

    public static void main(String[] args) {

        UniquePaths solver = new UniquePaths();

        System.out.println("Example 1:");
        System.out.println("m = 3, n = 6");
        System.out.println("Output: " + solver.uniquePaths(3, 6)); // 21

        System.out.println();

        System.out.println("Example 2:");
        System.out.println("m = 3, n = 3");
        System.out.println("Output: " + solver.uniquePaths(3, 3)); // 6
    }

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        // Base case: first row = 1
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Base case: first column = 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // Fill DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}