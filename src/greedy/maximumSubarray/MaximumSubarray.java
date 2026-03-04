package greedy.maximumSubarray;

public class MaximumSubarray {

    public static void main(String[] args) {

        MaximumSubarray solver = new MaximumSubarray();

        System.out.println("Example 1:");
        System.out.println(
                solver.maxSubArray(new int[]{2,-3,4,-2,2,1,-1,4})
        ); // 8

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.maxSubArray(new int[]{-1})
        ); // -1
    }

    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}