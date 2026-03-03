package dynamicProgramming.twod.distinctSubsequences;

public class DistinctSubsequences {

    public static void main(String[] args) {

        DistinctSubsequences solver = new DistinctSubsequences();

        System.out.println("Example 1:");
        System.out.println(
                solver.numDistinct("caaat", "cat")
        ); // 3

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.numDistinct("xxyxy", "xy")
        ); // 5
    }

    public int numDistinct(String s, String t) {

        int m = s.length();
        int n = t.length();

        if (n > m)
            return 0;

        long[][] dp = new long[m + 1][n + 1];

        // Base case: empty t
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {

                    dp[i][j] =
                            dp[i - 1][j - 1] +
                                    dp[i - 1][j];

                } else {

                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return (int) dp[m][n];
    }
}