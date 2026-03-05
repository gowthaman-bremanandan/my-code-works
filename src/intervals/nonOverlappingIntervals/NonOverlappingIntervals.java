package intervals.nonOverlappingIntervals;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public static void main(String[] args) {

        NonOverlappingIntervals solver = new NonOverlappingIntervals();

        System.out.println("Example 1:");
        System.out.println(
                solver.eraseOverlapIntervals(
                        new int[][]{{1,2},{2,4},{1,4}}
                )
        ); // 1

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.eraseOverlapIntervals(
                        new int[][]{{1,2},{2,4}}
                )
        ); // 0
    }

    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length <= 1)
            return 0;

        // Sort by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int countKeep = 1;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= prevEnd) {

                countKeep++;
                prevEnd = intervals[i][1];
            }
        }

        return intervals.length - countKeep;
    }
}