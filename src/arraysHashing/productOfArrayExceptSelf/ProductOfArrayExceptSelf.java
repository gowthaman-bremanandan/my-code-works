package arraysHashing.productOfArrayExceptSelf;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        ProductOfArrayExceptSelf solver = new ProductOfArrayExceptSelf();

        int[] nums = {1,2,4,6};

        System.out.println(Arrays.toString(
                solver.productExceptSelf(nums)
        ));
    }

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        result[0] = 1;

        // prefix product
        for (int i = 1; i < n; i++) {
            result[i] = result[i-1] * nums[i-1];
        }

        int suffix = 1;

        // suffix product
        for (int i = n-1; i >= 0; i--) {

            result[i] = result[i] * suffix;

            suffix *= nums[i];
        }

        return result;
    }
}