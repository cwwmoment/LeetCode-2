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

}