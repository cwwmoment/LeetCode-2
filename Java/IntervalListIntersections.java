/**
 * Created on 11 Mar 2019 by happygirlzt
 *
 * LeetCode #986. Interval List Intersections
 *
 */

class Solution {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int lo = Math.max(A[i].start, B[j].start);
            int hi = Math.min(A[i].end, B[j].end);

            if (lo <= hi) {
                res.add(new Interval(lo, hi));
            }

            if (A[i].end < B[j].end) {
                i++;
            } else {
                j++;
            }
        }

        return res.toArray(new Interval[0]);
    }
}
