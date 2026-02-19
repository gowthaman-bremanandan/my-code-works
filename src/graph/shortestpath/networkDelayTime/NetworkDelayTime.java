package graph.shortestpath.networkDelayTime;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {

        int[][] times = {
                {1,2,1},
                {2,3,1},
                {1,4,4},
                {3,4,1}
        };

        int n = 4;
        int k = 1;

        System.out.println(networkDelayTime(times, n, k));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        // Build adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] edge : times) {
            graph
                    .computeIfAbsent(edge[0], x -> new ArrayList<>())
                    .add(new int[]{edge[1], edge[2]});
        }

        // Min heap: [node, distance]
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.offer(new int[]{k, 0});

        Map<Integer, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {

            int[] current = pq.poll();
            int node = current[0];
            int time = current[1];

            if (dist.containsKey(node))
                continue;

            dist.put(node, time);

            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int weight = neighbor[1];

                    if (!dist.containsKey(nextNode)) {
                        pq.offer(new int[]{nextNode, time + weight});
                    }
                }
            }
        }

        if (dist.size() != n)
            return -1;

        int max = 0;

        for (int t : dist.values()) {
            max = Math.max(max, t);
        }

        return max;
    }
}
