package graph.topological.courseSchedule2;

import java.util.*;

public class CourseSchedule2 {

    public static void main(String[] args) {

        int numCourses = 3;
        int[][] prerequisites = {
                {1, 0}
        };

        int[] order = findOrder(numCourses, prerequisites);

        System.out.println(Arrays.toString(order));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // Step 1: Initialize graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Build graph
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];

            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Step 3: Add indegree 0 nodes
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        // Step 4: Process
        while (!queue.isEmpty()) {

            int curr = queue.poll();
            result[index++] = curr;

            for (int neighbor : graph.get(curr)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 5: Check for cycle
        if (index == numCourses) {
            return result;
        }

        return new int[0];
    }
}
