/**
 * Created on 6 Dec 2018 by happygirlzt
 *
 * LeetCode #941. Valid Mountain Array
 *
 */

public class ValidMountainArray {
    public boolean validMountainArray(int[] a) {
        int left = 0, right = a.length - 1;

        while (left < a.length - 1 && a[left + 1] > a[left]) {
            left++;
        }

        while (right > 0 && a[right - 1] > a[right]) {
            right--;
        }

        if (left == 0 || right == a.length - 1) return false;
        return left == right;
    }
}
