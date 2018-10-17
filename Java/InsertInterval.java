/**
 * LeetCode #57. Insert Interval
 * 
 * @author happygirlzt
 *
 */
import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	/**
	 * 题解：这题思路和上一题差不多。我还多此一举排了序，题目说了默认是排好序的。。
	 * 难点在于如何把newInterval给merge进去，主要是merge进去的可能还能和后面的interval
	 * merge，所以算是上题的进阶版。我的思路和上题一样，所有空间复杂度不小。看了人家的答案
	 * 是in-place的，直接更新newInterval就可以了。
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	// Solution 0: my naive solution
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<>();
		if (intervals == null || intervals.size() == 0) {
			res.add(newInterval);
			return res;
		}
		
		// lambda
		res.sort((Interval l1, Interval l2) -> (l1.start - l2.start));
		
		if (newInterval.start > intervals.get(intervals.size()-1).end) {
			intervals.add(newInterval);
			return intervals;
		}
		
		int start = newInterval.start;
		int end = newInterval.end;
		
		for (Interval interval: intervals) {
			// no overlap
			if (interval.start > end) {
				res.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			} else if (start <= interval.end) {
				// Overlapped
				end = Math.max(end, interval.end);
				start = Math.min(start, interval.start);
				// res.add(new Interval(start, end));
			} else if (start > interval.end) {
				// no overlap
				res.add(interval);
			}			
		}
		
		res.add(new Interval(start, end));
		return res;
 	}
	
	// Solution 1: Clear idea
	public static List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<>();
		
		for (Interval interval: intervals) {
			// new.start > interval.end
			if (newInterval == null || newInterval.start > interval.end) {
				res.add(interval);
			} else if (newInterval.end < interval.start) {
				// new.end < interval.start
				res.add(newInterval);
				res.add(interval);
				newInterval = null;
			} else {
				newInterval.start = Math.min(newInterval.start, interval.start);
				newInterval.end = Math.max(newInterval.end, interval.end);
			}
		}
		
		if (newInterval != null) res.add(newInterval);
		
		return res;
	}
	public static void main(String[] args) {
		Interval i0 = new Interval(1, 5);

		List<Interval> list = new ArrayList<>();
		list.add(i0);

		Interval newInter = new Interval(5, 7);
		List<Interval> res = new ArrayList<>();
		res = insert(list, newInter);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).start + " " + res.get(i).end);
		}
	}
}
