package intervals.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {

        MergeIntervals solver = new MergeIntervals();

        System.out.println("Example 1:");
        printResult(
                solver.merge(new int[][]{{1,3},{1,5},{6,7}})
        ); // [[1,5],[6,7]]

        System.out.println();

        System.out.println("Example 2:");
        printResult(
                solver.merge(new int[][]{{1,2},{2,3}})
        ); // [[1,3]]
    }

    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1)
            return intervals;

        // Step 1: Sort by start
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= current[1]) {

                // Overlapping
                current[1] = Math.max(current[1], intervals[i][1]);

            } else {

                // No overlap
                result.add(current);
                current = intervals[i];
            }
        }

        result.add(current);

        return result.toArray(new int[result.size()][]);
    }

    private static void printResult(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.print(Arrays.toString(interval) + " ");
        }
        System.out.println();
    }
}