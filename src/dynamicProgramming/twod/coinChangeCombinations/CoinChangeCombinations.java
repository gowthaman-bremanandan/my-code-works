package dynamicProgramming.twod.coinChangeCombinations;

public class CoinChangeCombinations {

    public static void main(String[] args) {

        CoinChangeCombinations solver = new CoinChangeCombinations();

        System.out.println("Example 1:");
        System.out.println(
                solver.change(4, new int[]{1,2,3})
        ); // 4

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.change(7, new int[]{2,4})
        ); // 0
    }

    public int change(int amount, int[] coins) {

        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];

        // Base case: amount 0 = 1 way
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= amount; j++) {

                // Not taking current coin
                dp[i][j] = dp[i - 1][j];

                // Taking current coin (if possible)
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[n][amount];
    }
}