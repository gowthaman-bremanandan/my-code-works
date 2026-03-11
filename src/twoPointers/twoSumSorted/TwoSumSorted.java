package twoPointers.twoSumSorted;

import java.util.Arrays;

public class TwoSumSorted {

    public static void main(String[] args) {

        TwoSumSorted solver = new TwoSumSorted();

        int[] numbers = {1,2,3,4};
        int target = 3;

        System.out.println(
                Arrays.toString(
                        solver.twoSum(numbers, target)
                )
        );
    }

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1}; // 1-indexed
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1}; // problem guarantees solution
    }
}