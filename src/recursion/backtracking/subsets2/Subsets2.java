package recursion.backtracking.subsets2;

import java.util.*;

public class Subsets2 {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 1};
        System.out.println(subsetsWithDup(nums1));

        int[] nums2 = {7, 7};
        System.out.println(subsetsWithDup(nums2));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums,
                                  int start,
                                  List<Integer> current,
                                  List<List<Integer>> result) {

        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            // Skip duplicates at same recursion level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);

            backtrack(nums, i + 1, current, result);

            current.remove(current.size() - 1);
        }
    }
}
