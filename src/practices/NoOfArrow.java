package practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;

public class NoOfArrow {

    public static void main(String[] args) {
        System.out.println(noOfArrowrequired(new int[][]{{1, 4}, {2, 5}, {5, 8}, {6, 9}, {10, 12}, {11, 13}})); // 3
        System.out.println(noOfArrowrequired(new int[][]{{1, 10}, {2, 9}, {3, 8}, {11, 15}, {12, 14}, {16, 18}})); // 3
        System.out.println(noOfArrowrequired(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}})); // 2
        System.out.println(noOfArrowrequired(new int[][]{{9, 12}, {1, 4}, {2, 3}, {5, 8}, {6, 7}, {10, 11}})); // 3
        System.out.println(noOfArrowrequired(new int[][]{{1, 100}, {10, 20}, {30, 40}, {50, 60}})); // 3
        System.out.println(noOfArrowrequired(new int[][]{{1, 10}, {2, 9}, {3, 8}, {4, 7}, {5, 6}})); // 1
        System.out.println(noOfArrowrequired(new int[][]{{-2147483648, 2147483647}})); // 1
        System.out.println(noOfArrowrequired(new int[][]{{1, 5}, {2, 6}, {3, 7}, {8, 10}, {9, 11}, {12, 16}, {13, 14}, {15, 18}})); // 4
    }

    private static int noOfArrowrequired(int[][] points) {

        if (points.length <= 1)
            return points.length;

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int arrowPos = points[0][1];

        for (int i = 1; i < points.length; i++) {

            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;
    }
}
