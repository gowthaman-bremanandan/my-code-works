package recursion.backtracking.subsets;

import java.util.*;

public class Subsets {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3};
        System.out.println(subsets(nums1));

        int[] nums2 = {7};
        System.out.println(subsets(nums2));
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int start,
                                  List<Integer> current,
                                  List<List<Integer>> result) {

        // Add current subset
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(nums, i + 1, current, result);

            // Undo choice (Backtrack)
            current.remove(current.size() - 1);
        }
    }
}
