package graph.unionfind.redundantConnection;

public class RedundantConnection {

    public static void main(String[] args) {

        int[][] edges = {
                {1,2},
                {1,3},
                {3,4},
                {2,4}
        };

        int[] result = findRedundantConnection(edges);

        System.out.println("[" + result[0] + "," + result[1] + "]");
    }

    public static int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {

            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);

            if (root1 == root2) {
                return edge; // cycle found
            }

            parent[root1] = root2;
        }

        return new int[0];
    }

    private static int find(int[] parent, int node) {

        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }

        return parent[node];
    }
}
