package recursion.backtracking.permutations;

import java.util.*;

public class Permutations {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3};
        System.out.println(permute(nums1));

        int[] nums2 = {7};
        System.out.println(permute(nums2));
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums,
                                  boolean[] used,
                                  List<Integer> current,
                                  List<List<Integer>> result) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            // Choose
            used[i] = true;
            current.add(nums[i]);

            // Explore
            backtrack(nums, used, current, result);

            // Undo
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
