package graph.dfs.validTree;

import java.util.*;

public class ValidTree {

    public static void main(String[] args) {

        int n = 5;
        int[][] edges = {
                {0,1},
                {0,2},
                {0,3},
                {3,0}
        };

        System.out.println(validTree(n, edges));
    }

    public static boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        if (hasCycle(graph, visited, 0, -1)) return false;

        // Check if all nodes are visited (connected)
        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }

    private static boolean hasCycle(List<List<Integer>> graph,
                                    boolean[] visited,
                                    int node,
                                    int parent) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {
                if (hasCycle(graph, visited, neighbor, node))
                    return true;
            }
            else if (neighbor != parent) {
                return true; // cycle found
            }
        }

        return false;
    }
}
