package graph.dfs.connectedComponents;

import java.util.*;

public class ConnectedComponents {

    public static void main(String[] args) {

        int n = 5;
        int[][] edges = {
                {0,1},
                {1,2},
                {3,4}
        };

        System.out.println(countComponents(n, edges));
    }

    public static int countComponents(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                dfs(graph, visited, i);
                count++;
            }
        }

        return count;
    }

    private static void dfs(List<List<Integer>> graph,
                            boolean[] visited,
                            int node) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }
}
