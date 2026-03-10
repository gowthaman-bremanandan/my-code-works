package slidingWindow.slidingWindowMaximum;

import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String[] args) {

        SlidingWindowMaximum solver = new SlidingWindowMaximum();

        int[] nums = {1,2,1,0,4,2,6};
        int k = 3;

        System.out.println(Arrays.toString(
                solver.maxSlidingWindow(nums, k)
        ));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new ArrayDeque<>();

        int[] result = new int[nums.length - k + 1];
        int index = 0;

        for (int right = 0; right < nums.length; right++) {

            while (!deque.isEmpty() &&
                    nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }

            deque.offerLast(right);

            if (deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }

            if (right >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}