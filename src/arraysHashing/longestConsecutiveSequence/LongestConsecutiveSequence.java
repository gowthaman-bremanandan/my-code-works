package arraysHashing.longestConsecutiveSequence;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        LongestConsecutiveSequence solver = new LongestConsecutiveSequence();

        int[] nums = {2,20,4,10,3,4,5};

        System.out.println(solver.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {

                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}