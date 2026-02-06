package linkedList.arrow;

import java.util.Arrays;

public class MinArrows {

    public static void main(String[] args) {

        int[][] points1 = {{1,6},{2,8},{7,12},{10,16}};
        System.out.println(findMinArrowShots(points1)); // Expected: 2

        int[][] points2 = {{1,2},{3,4},{5,6},{7,8}};
        System.out.println(findMinArrowShots(points2)); // Expected: 4

        int[][] points3 = {{1,10},{2,3},{4,5},{6,7},{8,9}};
        System.out.println(findMinArrowShots(points3)); // Expected: 4
    }

    public static int findMinArrowShots(int[][] points) {

        if (points == null || points.length == 0) {
            return 0;
        }

        // 1. Sort by end coordinate
        Arrays.sort(points, (a, b) -> {
            if (a[1] < b[1]) return -1;
            if (a[1] > b[1]) return 1;
            return 0;
        });

        int arrows = 1;
        int arrowPos = points[0][1];

        // 2. Greedy scan
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;
    }
}
