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

	public static void main(String[] args) {
		int[] nums = {1,1,0};
		System.out.println(isMonotonic(nums));
	}
}
