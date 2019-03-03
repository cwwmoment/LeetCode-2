/**
 * Created on 1 Nov 2018 by happygirlzt
 *
 * LeetCode #69. Sqrt(x)
 *
 */

public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x > 0 && x < 4) return 1;

        int left = 1, right = x / 2;

        while (true) {
            int mid = (left + right) >> 1;

            if (mid > 0 && mid > x / mid) {
                right = mid - 1;
            } else if (mid + 1 > x / (mid + 1)) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
    }

    // Updated on 3 Mar 2019
    public int mySqrt1(int x) {
        if (x == 0) return 0;
        int lo = 1;
        int hi = x / 2;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) return mid;

            if (mid < x / mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return 0;
    }
}
