package dynamicProgramming.twod.interleavingString;

public class InterleavingString {

    public static void main(String[] args) {

        InterleavingString solver = new InterleavingString();

        System.out.println("Example 1:");
        System.out.println(solver.isInterleave("aaaa", "bbbb", "aabbbbaa")); // true

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(solver.isInterleave("", "", "")); // true

        System.out.println();

        System.out.println("Example 3:");
        System.out.println(solver.isInterleave("abc", "xyz", "abxzcy")); // false
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length();
        int n = s2.length();

        if (m + n != s3.length()) return false;

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        // Fill first column (only s1)
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // Fill first row (only s2)
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Fill remaining cells
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                char c = s3.charAt(i + j - 1);

                boolean fromS1 = s1.charAt(i - 1) == c && dp[i - 1][j];

                boolean fromS2 = s2.charAt(j - 1) == c && dp[i][j - 1];

                dp[i][j] = fromS1 || fromS2;
            }
        }

        return dp[m][n];
    }
}