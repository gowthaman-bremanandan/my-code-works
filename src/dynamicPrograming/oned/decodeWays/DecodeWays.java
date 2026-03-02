package dynamicPrograming.oned.decodeWays;

public class DecodeWays {

    public static void main(String[] args) {

        DecodeWays solver = new DecodeWays();

        System.out.println("Input: 12");
        System.out.println("Output: " + solver.numDecodings("12"));
        System.out.println();

        System.out.println("Input: 1012");
        System.out.println("Output: " + solver.numDecodings("1012"));
        System.out.println();

        System.out.println("Input: 01");
        System.out.println("Output: " + solver.numDecodings("01"));
    }

    public int numDecodings(String s) {

        if (s.length() == 0 || s.charAt(0) == '0')
            return 0;

        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            int oneDigit = s.charAt(i - 1) - '0';
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            // Single digit valid
            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }

            // Two digit valid (10 to 26)
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}