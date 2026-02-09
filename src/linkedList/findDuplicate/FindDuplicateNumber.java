package linkedList.findDuplicate;

public class FindDuplicateNumber {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 4};
        System.out.println(findDuplicate(nums1)); // Expected: 4

        int[] nums2 = {1, 2, 3, 4, 4};
        System.out.println(findDuplicate(nums2)); // Expected: 4
    }

    public static int findDuplicate(int[] nums) {

        // Phase 1: Detect cycle
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entry point of cycle
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
