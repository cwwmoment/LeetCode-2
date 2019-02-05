/**
 * LeetCode #852. Peak Index in a Mountain Array
 * @author happygirlzt
 *
 */
public class PeakIndexInMountainArray {

    public static int isSorted(int[] a) {
        int i = 0;
        while((i < a.length - 1)&&(a[i] < a[i+1])) {
            i++;
        }
        return i;
    }

    public static int peakIndex(int[] A) {
        int index = isSorted(A);
        return index;
    }

    public static void main(String[] args) {
        int[] b = {0, 2, 1, 0};
        System.out.println(peakIndex(b));
    }

    // Updated on 5 Feb 2019
    public int peakIndexInMountainArray1(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] < A[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}
