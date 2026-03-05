package intervals.insertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {

        InsertInterval solver = new InsertInterval();

        System.out.println("Example 1:");
        printResult(
                solver.insert(
                        new int[][]{{1,3},{4,6}},
                        new int[]{2,5}
                )
        ); // [[1,6]]

        System.out.println();

        System.out.println("Example 2:");
        printResult(
                solver.insert(
                        new int[][]{{1,2},{3,5},{9,10}},
                        new int[]{6,7}
                )
        ); // [[1,2],[3,5],[6,7],[9,10]]
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        // Phase 1: Add intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Phase 2: Merge overlaps
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        // Phase 3: Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    private static void printResult(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.print(Arrays.toString(interval) + " ");
        }
        System.out.println();
    }
}