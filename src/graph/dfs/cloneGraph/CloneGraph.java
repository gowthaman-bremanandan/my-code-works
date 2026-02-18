package graph.dfs.cloneGraph;

import java.util.*;

public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    public static void main(String[] args) {

        // Example: 1 -- 2 -- 3
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        node2.neighbors.add(node3);
        node3.neighbors.add(node2);

        Node cloned = cloneGraph(node1);

        System.out.println(cloned.val); // 1
        System.out.println(cloned.neighbors.get(0).val); // 2
    }

    public static Node cloneGraph(Node node) {

        if (node == null) return null;

        Map<Node, Node> visited = new HashMap<>();

        return dfs(node, visited);
    }

    private static Node dfs(Node node,
                            Map<Node, Node> visited) {

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node clone = new Node(node.val);
        visited.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, visited));
        }

        return clone;
    }
}
