package dynamicPrograming.oned.maxProductSubarray;

public class MaxProductSubarray {

    public static void main(String[] args) {

        MaxProductSubarray solver = new MaxProductSubarray();

        System.out.println("Example 1:");
        System.out.println(solver.maxProduct(new int[]{1,2,-3,4})); // 4

        System.out.println("Example 2:");
        System.out.println(solver.maxProduct(new int[]{-2,-1})); // 2

        System.out.println("Example 3:");
        System.out.println(solver.maxProduct(new int[]{2,3,-2,4})); // 6
    }

    public int maxProduct(int[] nums) {

        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int current = nums[i];

            // If negative, swap max and min
            if (current < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(current, current * max);
            min = Math.min(current, current * min);

            result = Math.max(result, max);
        }

        return result;
    }
}