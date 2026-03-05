package intervals.minimumIntervalForQueries;

import java.util.*;

public class MinimumIntervalForQueries {

    public static void main(String[] args) {

        MinimumIntervalForQueries solver = new MinimumIntervalForQueries();

        int[][] intervals = {{1,3},{2,3},{3,7},{6,6}};
        int[] queries = {2,3,1,7,6,8};

        System.out.println(Arrays.toString(
                solver.minInterval(intervals, queries)
        ));
        // [2,2,3,5,1,-1]
    }

    public int[] minInterval(int[][] intervals, int[] queries) {

        int n = queries.length;

        int[] result = new int[n];

        // Sort intervals by start
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Store queries with original index
        int[][] sortedQueries = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap sorted by interval length
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int i = 0; // pointer for intervals

        for (int[] query : sortedQueries) {

            int q = query[0];
            int index = query[1];

            // Add all intervals whose start <= q
            while (i < intervals.length && intervals[i][0] <= q) {

                int start = intervals[i][0];
                int end = intervals[i][1];

                int length = end - start + 1;

                minHeap.add(new int[]{length, end});
                i++;
            }

            // Remove intervals that cannot cover q
            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }

            if (minHeap.isEmpty()) {
                result[index] = -1;
            } else {
                result[index] = minHeap.peek()[0];
            }
        }

        return result;
    }
}