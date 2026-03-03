package dynamicProgramming.twod.regexMatching;

public class RegexMatching {

    public static void main(String[] args) {

        RegexMatching solver = new RegexMatching();

        System.out.println("Example 1:");
        System.out.println(
                solver.isMatch("aa", ".b")
        ); // false

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.isMatch("nnn", "n*")
        ); // true

        System.out.println();

        System.out.println("Example 3:");
        System.out.println(
                solver.isMatch("xyz", ".*z")
        ); // true
    }

    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        // Handle patterns like a*, a*b*, etc.
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (p.charAt(j - 1) == '.' ||
                        p.charAt(j - 1) == s.charAt(i - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else if (p.charAt(j - 1) == '*') {

                    // zero occurrence
                    dp[i][j] = dp[i][j - 2];

                    // one or more
                    if (p.charAt(j - 2) == '.' ||
                            p.charAt(j - 2) == s.charAt(i - 1)) {

                        dp[i][j] =
                                dp[i][j] ||
                                        dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}