package binarySearch.findMinRotated;

public class FindMinimumInRotatedArray {

    public static void main(String[] args) {

        System.out.println(findMin(new int[]{3,4,5,6,1,2})); // 1
        System.out.println(findMin(new int[]{4,5,0,1,2,3})); // 0
        System.out.println(findMin(new int[]{4,5,6,7}));     // 4
    }

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Minimum is in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // Minimum is in left half (including mid)
            else {
                right = mid;
            }
        }

        return nums[left];
    }
}
