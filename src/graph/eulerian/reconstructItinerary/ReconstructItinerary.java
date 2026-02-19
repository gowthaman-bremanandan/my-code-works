package graph.eulerian.reconstructItinerary;

import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args) {

        List<List<String>> tickets = new ArrayList<>();
//        tickets.add(Arrays.asList("HOU","JFK"));
//        tickets.add(Arrays.asList("SEA","JFK"));
//        tickets.add(Arrays.asList("JFK","SEA"));
//        tickets.add(Arrays.asList("JFK","HOU"));

        tickets.add(Arrays.asList("HOU","SEA"));
        tickets.add(Arrays.asList("HOU","FLY"));
        tickets.add(Arrays.asList("FLY","HOU"));
        tickets.add(Arrays.asList("SEA","HOU"));
        tickets.add(Arrays.asList("HOU","JFK"));
        tickets.add(Arrays.asList("JFK","HOU"));

        System.out.println(findItinerary(tickets));
    }

    public static List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        // Build graph with lexicographically sorted destinations
        for (List<String> ticket : tickets) {
            graph
                    .computeIfAbsent(ticket.get(0), x -> new PriorityQueue<>())
                    .offer(ticket.get(1));
        }

        LinkedList<String> result = new LinkedList<>();

        dfs("JFK", graph, result);

        return result;
    }

    private static void dfs(String airport,
                            Map<String, PriorityQueue<String>> graph,
                            LinkedList<String> result) {

        PriorityQueue<String> destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty()) {

            String next = destinations.poll();
            dfs(next, graph, result);
        }

        // Add after exploring all edges
        result.addFirst(airport);
    }
}
