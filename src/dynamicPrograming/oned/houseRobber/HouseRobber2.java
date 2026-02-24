package dynamicPrograming.oned.houseRobber;

public class HouseRobber2 {

    public static int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        // Case 1: exclude last house
        int case1 = robLinear(nums, 0, nums.length - 2);

        // Case 2: exclude first house
        int case2 = robLinear(nums, 1, nums.length - 1);

        return Math.max(case1, case2);
    }

    private static int robLinear(int[] nums, int start, int end) {

        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int i = start; i <= end; i++) {
            int current = Math.max(
                    prev1,
                    nums[i] + prev2
            );

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
