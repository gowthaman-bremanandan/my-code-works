package graph.unionfind.validTree;

public class ValidTree {

    public static void main(String[] args) {

        int n = 5;
        int[][] edges = {
                {0,1},
                {1,2},
                {2,3},
                {1,4}
        };

        System.out.println(validTree(n, edges));
    }

    public static boolean validTree(int n, int[][] edges) {

        // Rule 1: Tree must have exactly n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {

            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);

            if (root1 == root2) {
                return false; // cycle found
            }

            parent[root2] = root1; // union
        }

        return true;
    }

    private static int find(int[] parent, int node) {

        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]); // path compression
        }

        return parent[node];
    }
}
