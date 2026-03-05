package intervals.meetingRoomsII;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public static void main(String[] args) {

        MeetingRoomsII solver = new MeetingRoomsII();

        System.out.println("Example 1:");
        System.out.println(
                solver.minMeetingRooms(
                        new int[][]{{0,40},{5,10},{15,20}}
                )
        ); // 2

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.minMeetingRooms(
                        new int[][]{{4,9}}
                )
        ); // 1
    }

    public int minMeetingRooms(int[][] intervals) {

        if (intervals.length <= 1)
            return intervals.length;

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Min heap for end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add first meeting
        minHeap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {

            // If earliest ending meeting ends before current starts
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll(); // reuse room
            }

            // Add current meeting's end time
            minHeap.add(intervals[i][1]);
        }

        return minHeap.size();
    }
}