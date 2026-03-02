package dynamicPrograming.oned.longestIncreasingSubsequence;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        LongestIncreasingSubsequence solver =
                new LongestIncreasingSubsequence();

        System.out.println("Example 1:");
        System.out.println(
                solver.lengthOfLIS(new int[]{9,1,4,2,3,3,7})
        ); // 4

        System.out.println("Example 2:");
        System.out.println(
                solver.lengthOfLIS(new int[]{0,3,1,3,2,3})
        ); // 4
    }

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];

        int maxLength = 1;

        for (int i = 0; i < nums.length; i++) {

            dp[i] = 1;

            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}