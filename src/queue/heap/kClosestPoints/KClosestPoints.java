package queue.heap.kClosestPoints;

import java.util.*;

public class KClosestPoints {

    public static void main(String[] args) {

        int[][] points1 = {{0, 2}, {2, 2}};
        int k1 = 1;
        printResult(kClosest(points1, k1));

        int[][] points2 = {{0, 2}, {2, 0}, {2, 2}};
        int k2 = 2;
        printResult(kClosest(points2, k2));

        int[][] points3 = {{2, 0}, {0, 1}, {0, 3}, };
        int k3 = 1;
        printResult(kClosest(points3, k3));
    }

    public static int[][] kClosest(int[][] points, int k) {

        // Max heap (largest distance on top)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> distance(b) - distance(a)
        );

        for (int[] point : points) {

            maxHeap.offer(point);

            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove farthest
            }
        }

        int[][] result = new int[k][2];
        int index = 0;

        while (!maxHeap.isEmpty()) {
            result[index++] = maxHeap.poll();
        }

        return result;
    }

    private static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private static void printResult(int[][] result) {
        for (int[] point : result) {
            System.out.print("[" + point[0] + "," + point[1] + "] ");
        }
        System.out.println();
    }
}
