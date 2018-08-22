
/**
 * LeetCode #56. Merge Interval
 * 
 * @author happygirlzt
 *
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class MergeIntervals {
	/**
	 * 题意：这道题主要是考察写一个sort函数？通过这道题，我学会了如何写list的sort函数；
	 * 如何遍历、判断比较高效。我的方法太弱智了，特别容易出错；别人的方法就每次更新一下start，
	 * end，然后继续比较就可以了。
	 * @param intervals
	 * @return
	 */
	// Solution 0: my naive solution
	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();

		if (intervals == null)
			return res;
		if (intervals.size() == 1) {
			res.add(intervals.get(0));
			return res;
		}

		intervals.sort(new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start == o2.start && o1.end == o2.end) {
					return 0;
				} else if (o1.start < o2.start || (o1.start == o2.start && o1.end < o2.end)) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		int st = 0;
		for (int i = 0; i < intervals.size() - 1; i++) {
			if (intervals.get(i).end < intervals.get(i+1).start) {
				res.add(intervals.get(i));
				st++;
				continue;
			}
			
			if (intervals.get(i) != null) {
				st += mergeTwo(intervals.get(i), intervals.get(i+1));
			} else {
				i++;
				st += mergeTwo(intervals.get(i), intervals.get(i+1));	
			}
		}
		
		for (int i = st; i < intervals.size(); i++) {
			res.add(intervals.get(i));
		}
		return res;		
	}

	public static int mergeTwo(Interval l1, Interval l2) {
		int count = 0;
		// List<Interval> res = new ArrayList<>();
		// e.g. [1, 3] [3, 7]
		if (l1.end == l2.start) {
			Interval merged = new Interval(l1.start, l2.end);

			l2.start = merged.start;
			l2.end = merged.end;
			l1 = null;
			count++;
		} else if ((l2.start >= l1.start && l2.start <= l1.end) && l2.end >= l1.end) {
			// e.g. [1, 7], [1, 9]
			Interval merged = new Interval(l1.start, l2.end);

			l2.start = merged.start;
			l2.end = merged.end;
			l1 = null;
			count++;
			
		} else if (l2.start >= l1.start && l2.end <= l1.end) {
			// e.g. [1, 7], [1, 4]
			l2.start = l1.start;
			l2.end = l1.end;
			l1 = null;
			count++;
		} else if (l1.start == l2.start && l1.end == l2.end) {
			// e.g. [1, 3], [1, 3]
			l2 = null;
			count++;
		}
		return count;
	}

	// Solution 1
	public List<Interval> merge1(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		if (intervals == null || intervals.size() == 0) return res;
		
		intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
		
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		
		for (Interval interval : intervals) {
			// Overlapped
			if (interval.start <= end) {
				end = Math.max(interval.end, end);
			} else {
				res.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		
		res.add(new Interval(start, end));
		
		return res;
	}
	
	public static void main(String[] args) {
		// [[2,3],[2,2],[3,3],[1,3],[5,7],[2,2],[4,6]]
		
		Interval i0 = new Interval(2, 3);
		Interval i1 = new Interval(2, 2);
		Interval i2 = new Interval(3, 3);
		Interval i3 = new Interval(1, 3);
		Interval i4 = new Interval(5, 7);
		Interval i5 = new Interval(2, 2);
		Interval i6 = new Interval(4, 6);

		List<Interval> list = new ArrayList<>();
		list.add(i0);
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		list.add(i5);
		list.add(i6);

		List<Interval> res = new ArrayList<>();
		
		res = merge(list);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).start + " " + res.get(i).end);
		}
	}
}
