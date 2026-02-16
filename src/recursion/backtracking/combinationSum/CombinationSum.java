package recursion.backtracking.combinationSum;

import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {

        int[] nums1 = {2, 5, 6, 9};
        int target1 = 9;
        System.out.println(combinationSum(nums1, target1));

        int[] nums2 = {3, 4, 5};
        int target2 = 16;
        System.out.println(combinationSum(nums2, target2));

        int[] nums3 = {3};
        int target3 = 5;
        System.out.println(combinationSum(nums3, target3));
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int target,
                                  int start,
                                  List<Integer> current,
                                  List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {

            // Choose
            current.add(nums[i]);

            // Explore (i, not i+1 because unlimited reuse allowed)
            backtrack(nums, target - nums[i], i, current, result);

            // Undo (backtrack)
            current.remove(current.size() - 1);
        }
    }
}
