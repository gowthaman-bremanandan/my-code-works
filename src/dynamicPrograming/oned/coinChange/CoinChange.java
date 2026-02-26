package dynamicPrograming.oned.coinChange;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {

        CoinChange solver = new CoinChange();

        System.out.println("Example 1:");
        System.out.println(solver.coinChange(new int[]{1,5,10}, 12)); // 3

        System.out.println("Example 2:");
        System.out.println(solver.coinChange(new int[]{2}, 3)); // -1

        System.out.println("Example 3:");
        System.out.println(solver.coinChange(new int[]{1}, 0)); // 0

        System.out.println("Example 3:");
        System.out.println(solver.coinChange(new int[]{5}, 7)); // 0
    }

    public int coinChange(int[] coins, int amount) {

        if (amount == 0)
            return 0;

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}