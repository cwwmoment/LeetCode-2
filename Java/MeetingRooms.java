/**
 * Created on 12 Dec 2018 by happygirlzt
 *
 * LeetCode #252. Meeting Rooms
 *
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        // corner case
        if (intervals == null || intervals.length == 0) return true;

        int size = intervals.length;
        int[] starts = new int[size];
        int[] ends = new int[size];

        int idx = 0;
        for (Interval inter: intervals) {
            starts[idx] = inter.start;
            ends[idx++] = inter.end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int i = 0;
        while (i < size) {
            int start = starts[i];
            if (i < size - 1 && starts[i + 1] < ends[i]) return false;
            i++;
        }

        return true;
    }

    // alternative

    public boolean canAttendMeetings1(Interval[] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i + 1].start < intervals[i].end) return false;
        }

        return true;
    }
}
