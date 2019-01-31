/**
 *
 * Created by happygirlzt on 2 Sep 2018 at 9:32:24 AM
 *
 */
public class MonotonicArray {
    public static boolean isMonotonic(int[] a) {
        if (a.length == 0 || a == null)
            return false;

        if (a.length == 1) return true;
        int len = a.length;

        if (a[len - 1] >= a[0]) {
            for (int i = 1; i < len; i++) {
                if (a[i] < a[i - 1]) {
                    return false;
                }
            }
        } else {
            for (int j = 1; j < len; j++) {
                if (a[j] > a[j - 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    // Updated on 31 Jan 2019
    public boolean isMonotonic1(int[] A) {
        if (A == null || A.length == 0) return true;
        boolean increasing = true, decreasing = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                increasing = false;
            }

            if (A[i] < A[i + 1]) {
                decreasing = false;
            }
        }

        return decreasing || increasing;
    }
}
