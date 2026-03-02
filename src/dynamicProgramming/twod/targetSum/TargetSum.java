package dynamicProgramming.twod.targetSum;

public class TargetSum {

    public static void main(String[] args) {

        TargetSum solver = new TargetSum();

        System.out.println("Example 1:");
        System.out.println(
                solver.findTargetSumWays(new int[]{2,2,2}, 2)
        ); // 3
    }

    public int findTargetSumWays(int[] nums, int target) {

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (Math.abs(target) > totalSum)
            return 0;

        if ((target + totalSum) % 2 != 0)
            return 0;

        int subsetSum = (target + totalSum) / 2;

        int n = nums.length;
        int[][] dp = new int[n + 1][subsetSum + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j <= subsetSum; j++) {

                dp[i][j] = dp[i - 1][j];

                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][subsetSum];
    }
}