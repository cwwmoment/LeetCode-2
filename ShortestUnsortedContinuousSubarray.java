/**
 * Created on 20 Sep 2018 by happygirlzt
 *
 * LeetCode #581. Shortest Unsorted Continuous Subarray
 */

public class ShortestUnsortedContinuousSubarray {
    // My naive solution, Space O(n)
    public int findUnsortedSubarray(int[] a) {
        int len = a.length;
        if (len == 0) return 0;

        int[] b = new int[len];
        for (int i = 0; i < len; i++) {
            b[i] = a[i];
        }

        Arrays.sort(a);
        int left = 0, right = len - 1;
        int start = 0, end = len - 1;
        while (left <= right) {
            if (b[left] == a[left]) {
                left++;
                start = left;
            } else {
                if (b[right] == a[right]) {
                    right--;
                    end = right;
                } else {
                    return end - start + 1;
                }
            }
        }

        return 0;
    }

    // Other's smart solution, Space O(1)
    public int findUnsortedSubarray1(int[] a) {
        int len = a.length;
        int left = 0, right = len - 1;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        while (left < len - 1) {
            if (a[left] > a[left + 1]) break;

            left++;
        }

        if (left == len - 1) return 0;
        while (right > 0) {
            if (a[right] < a[right - 1]) break;

            right--;
        }

        for (int i = left; i <= right; i++) {
            if (a[i] < min) {
                min = a[i];
            }

            if (a[i] > max) {
                max =a[i];
            }
        }

        while (left >= 0 && a[left] > min) {
            left--;
        }

        while (right < len && a[right] < max) {
            right++;
        }

        return right - left - 1;
    }
}
