/**
 * Created on 21 Jan 2019 by happygirlzt
 *
 * LeetCode #352. Data Stream as Disjoint Intervals
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
class SummaryRanges {
    // Solution 0: my naive solution, use start and end as the key and value of map
    TreeMap<Integer, Integer> map;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        boolean flag = false;
        Integer pre = map.floorKey(val);
        Integer next = map.ceilingKey(val);

        // System.out.println(pre);
        if (pre != null && map.get(pre) + 1 == val && next != null && next - 1 == val) {
            map.put(pre, map.get(next));
            map.remove(next);
            return;
        } else if (pre != null && map.get(pre) + 1 == val) {
            map.put(pre, val);
            return;
        } else if (next != null && next - 1 == val) {
            map.put(val, map.get(next));
            map.remove(next);
            return;
        } else if (pre != null && val >= pre && val <= map.get(pre) || next != null && val >= next && val <= map.get(next)) {
            return;
        } else {
            map.put(val, val);
        }
    }

    public List<Interval> getIntervals() {
        List<Interval> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            res.add(new Interval(i.getKey(), i.getValue()));
        }
        return res;
    }
}

// Solution 1: Use start and interval
class SummaryRanges {

    TreeMap<Integer, Interval> map;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        Integer pre = map.floorKey(val);
        Integer next = map.ceilingKey(val);

        if (pre != null && map.get(pre).end + 1 == val &&
            next != null && next - 1 == val) {
            map.put(pre, new Interval(pre, map.get(next).end));
            map.remove(next);
        } else if (pre != null && map.get(pre).end + 1 == val) {
            map.put(pre, new Interval(pre, val));
        } else if (next != null && next - 1 == val) {
            map.put(val, new Interval(val, map.get(next).end));
            map.remove(next);
        } else if (pre != null && val <= map.get(pre).end && val >= pre ||
                   next != null && val >= next && map.get(next).end >= val) {
            return;
        } else {
            map.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList(map.values());
    }
}
