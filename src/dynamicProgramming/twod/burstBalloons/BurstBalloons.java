package dynamicProgramming.twod.burstBalloons;

public class BurstBalloons {

    public static void main(String[] args) {

        BurstBalloons solver = new BurstBalloons();

        System.out.println("Example 1:");
        System.out.println(
                solver.maxCoins(new int[]{4,2,3,7})
        ); // 143
    }

    public int maxCoins(int[] nums) {

        int n = nums.length;

        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int length = 2; length < n + 2; length++) {

            for (int left = 0; left < n + 2 - length; left++) {

                int right = left + length;

                for (int k = left + 1; k < right; k++) {

                    dp[left][right] = Math.max(
                            dp[left][right],
                            dp[left][k] +
                                    dp[k][right] +
                                    arr[left] * arr[k] * arr[right]
                    );
                }
            }
        }

        return dp[0][n + 1];
    }
}