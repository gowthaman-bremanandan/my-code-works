package recursion.backtracking.combinationSum2;

import java.util.*;

public class CombinationSum2 {

    public static void main(String[] args) {

        int[] candidates1 = {9,2,2,4,6,1,5};
        int target1 = 8;
        System.out.println(combinationSum2(candidates1, target1));

        int[] candidates2 = {1,2,3,4,5};
        int target2 = 7;
        System.out.println(combinationSum2(candidates2, target2));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums,
                                  int target,
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

            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose
            current.add(nums[i]);

            // Explore (i + 1 because element can be used only once)
            backtrack(nums, target - nums[i], i + 1, current, result);

            // Undo
            current.remove(current.size() - 1);
        }
    }
}
