package dynamicProgramming.twod.stockWithCooldown;

public class StockWithCooldown {

    public static void main(String[] args) {

        StockWithCooldown solver = new StockWithCooldown();

        System.out.println("Example 1:");
        System.out.println(
                solver.maxProfit(new int[]{1,3,4,0,4})
        ); // 6

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.maxProfit(new int[]{1})
        ); // 0
    }

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1)
            return 0;

        int n = prices.length;

        int[] hold = new int[n];
        int[] sold = new int[n];
        int[] rest = new int[n];

        hold[0] = -prices[0];
        sold[0] = 0;
        rest[0] = 0;

        for (int i = 1; i < n; i++) {

            hold[i] = Math.max(
                    hold[i - 1],
                    rest[i - 1] - prices[i]
            );

            sold[i] = hold[i - 1] + prices[i];

            rest[i] = Math.max(
                    rest[i - 1],
                    sold[i - 1]
            );
        }

        return Math.max(sold[n - 1], rest[n - 1]);
    }
}