/**
 * Created on 23 Oct 2018 by happygirlzt
 *
 * LeetCode #253. Meeting Rooms II
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
public class MeetingRooms2 {
     class interComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return (i1.start - i2.start);
        }
    }

    public int minMeetingRooms(Interval[] intervals) {

        // 考虑一下为什么这个不行
        // Collections.sort(intervals, new Comparator<Interval>() {
        //
        //         @Override
        //         public int compare(Interval i1, Interval i2) {
        //             return i1.start < i2.start;
        //         }
        //     });
        Arrays.sort(intervals, new interComparator());

        int len = intervals.length;
        int res = 0, tmpStart = intervals[0].start;
        int tmpEnd = intervals[0].end;
        int maxEnd = intervals[0].end;

        if (len == 0 || intervals == null) return res;
        res++;

        for (int i = 1; i < len; i++) {
            if (intervals[i - 1].end >= intervals[i].end) {
                res++;
                tmpEnd = intervals[i].end;
                maxEnd = Math.max(maxEnd, intervals[i].end);
            } else if (intervals[i - 1].end <= intervals[i].start) {
                maxEnd = Math.max(maxEnd, intervals[i].end);
            }
        }

        return res;
    }

    public int minMeetingRooms2(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int res = 0;
        int endsItr = 0;
        for(int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[endsItr])
                res++;
            else
                endsItr++;
        }
        return res;
    }
}
