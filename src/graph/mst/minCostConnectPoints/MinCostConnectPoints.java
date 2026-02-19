package graph.mst.minCostConnectPoints;

import java.util.*;

public class MinCostConnectPoints {

    public static void main(String[] args) {

        int[][] points = {
                {0,0},
                {2,2},
                {3,3},
                {2,4},
                {4,2}
        };

        System.out.println(minCostConnectPoints(points));
    }

    public static int minCostConnectPoints(int[][] points) {

        int n = points.length;

        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.offer(new int[]{0, 0}); // start from point 0

        int totalCost = 0;
        int edgesUsed = 0;

        while (edgesUsed < n) {

            int[] current = pq.poll();
            int pointIndex = current[0];
            int cost = current[1];

            if (visited[pointIndex])
                continue;

            visited[pointIndex] = true;
            totalCost += cost;
            edgesUsed++;

            for (int i = 0; i < n; i++) {

                if (!visited[i]) {

                    int distance = Math.abs(points[pointIndex][0] - points[i][0]) +
                            Math.abs(points[pointIndex][1] - points[i][1]);

                    pq.offer(new int[]{i, distance});
                }
            }
        }

        return totalCost;
    }
}
