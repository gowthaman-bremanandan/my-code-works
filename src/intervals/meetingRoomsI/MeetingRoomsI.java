package intervals.meetingRoomsI;

import java.util.Arrays;

public class MeetingRoomsI {

    public static void main(String[] args) {

        MeetingRoomsI solver = new MeetingRoomsI();

        System.out.println("Example 1:");
        System.out.println(
                solver.canAttendMeetings(
                        new int[][]{{0,30},{5,10},{15,20}}
                )
        ); // false

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.canAttendMeetings(
                        new int[][]{{5,8},{9,15}}
                )
        ); // true
    }

    public boolean canAttendMeetings(int[][] intervals) {

        if (intervals.length <= 1)
            return true;

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Check overlap
        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }

        return true;
    }
}