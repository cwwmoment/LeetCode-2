/**
 * Created on 21 Jan 2019 by happygirlzt
 *
 * LeetCode #759. Employee Free Time
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
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> events = new ArrayList<>();
        for (List<Interval> worker : schedule) {
            for (Interval i : worker) {
                events.add(i);
            }
        }
        events.sort((e1, e2) -> (e1.start == e2.start ? e1.end - e2.end : e1.start - e2.start));
        List<Interval> res = new ArrayList<>();

        Interval pre = events.get(0);
        for (Interval each : events) {
            if (pre.end < each.start) {
                res.add(new Interval(pre.end, each.start));
                pre = each;
            } else {
                pre = pre.end < each.end ? each : pre;
            }
        }

        return res;
    }
}
