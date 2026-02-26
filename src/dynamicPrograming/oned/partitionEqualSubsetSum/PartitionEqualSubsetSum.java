package dynamicPrograming.oned.partitionEqualSubsetSum;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {

        PartitionEqualSubsetSum solver =
                new PartitionEqualSubsetSum();

        System.out.println("Example 1:");
        System.out.println(
                solver.canPartition(new int[]{1,2,3,4})
        ); // true

        System.out.println("Example 2:");
        System.out.println(
                solver.canPartition(new int[]{1,2,3,4,5})
        ); // false
    }

    public boolean canPartition(int[] nums) {

        int totalSum = 0;

        for (int num : nums)
            totalSum += num;

        if (totalSum % 2 != 0)
            return false;

        int target = totalSum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {

            for (int j = target; j >= num; j--) {

                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}