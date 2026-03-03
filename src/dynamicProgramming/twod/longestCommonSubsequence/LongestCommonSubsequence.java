package dynamicProgramming.twod.longestCommonSubsequence;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        LongestCommonSubsequence solver = new LongestCommonSubsequence();

        System.out.println("Example 1:");
        System.out.println(
                solver.longestCommonSubsequence("cat", "crabt")
        ); // 3

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.longestCommonSubsequence("abcd", "abcd")
        ); // 4

        System.out.println();

        System.out.println("Example 3:");
        System.out.println(
                solver.longestCommonSubsequence("abcd", "efgh")
        ); // 0
    }

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}