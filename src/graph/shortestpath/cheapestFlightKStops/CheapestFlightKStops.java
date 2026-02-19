package graph.shortestpath.cheapestFlightKStops;

import java.util.*;

public class CheapestFlightKStops {

    public static void main(String[] args) {

        int n = 4;
        int[][] flights = {
                {0,1,200},
                {1,2,100},
                {1,3,300},
                {2,3,100}
        };

        int src = 0;
        int dst = 3;
        int k = 1;

        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

    public static int findCheapestPrice(int n,
                                        int[][] flights,
                                        int src,
                                        int dst,
                                        int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] flight : flights) {
            graph
                    .computeIfAbsent(flight[0], x -> new ArrayList<>())
                    .add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        // {node, cost, stops}
        pq.offer(new int[]{src, 0, 0});

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int node = current[0];
            int cost = current[1];
            int step = current[2];

            if (node == dst)
                return cost;

            if (step > k || step > stops[node])
                continue;

            stops[node] = step;

            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {

                    pq.offer(new int[]{
                            neighbor[0],
                            cost + neighbor[1],
                            step + 1
                    });
                }
            }
        }

        return -1;
    }
}
