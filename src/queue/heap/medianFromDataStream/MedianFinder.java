package queue.heap.medianFromDataStream;

import java.util.*;

public class MedianFinder {

    private PriorityQueue<Integer> maxHeap; // Left half
    private PriorityQueue<Integer> minHeap; // Right half

    public MedianFinder() {

        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: Add to maxHeap
        maxHeap.offer(num);

        // Step 2: Ensure ordering property
        minHeap.offer(maxHeap.poll());

        // Step 3: Balance sizes
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
