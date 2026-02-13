package queue.heap.kthLargestElement;

import java.util.*;

public class KthLargestElement {

    public static void main(String[] args) {

        int[] nums1 = {2, 3, 1, 5, 4};
        int k1 = 2;
        System.out.println(findKthLargest(nums1, k1)); // 4

        int[] nums2 = {2, 3, 1, 1, 5, 5, 4};
        int k2 = 3;
        System.out.println(findKthLargest(nums2, k2)); // 4
    }

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {

            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();  // remove smallest
            }
        }

        return minHeap.peek();
    }
}
