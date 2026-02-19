package graph.topological.alienDictionary;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {

        String[] words = {"hrn","hrf","er","enn","rfnn"};

        System.out.println(alienOrder(words));
    }

    public static String alienOrder(String[] words) {

        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Initialize all characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        // Build graph
        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];
            String w2 = words[i + 1];

            if (w1.length() > w2.length() &&
                    w1.startsWith(w2)) {
                return "";
            }

            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {

                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (c1 != c2) {

                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }

                    break;
                }
            }
        }

        // Topological Sort
        Queue<Character> queue = new LinkedList<>();

        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0)
                queue.offer(c);
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {

            char current = queue.poll();
            result.append(current);

            for (char neighbor : graph.get(current)) {

                indegree.put(neighbor,
                        indegree.get(neighbor) - 1);

                if (indegree.get(neighbor) == 0)
                    queue.offer(neighbor);
            }
        }

        if (result.length() != indegree.size())
            return "";

        return result.toString();
    }
}
