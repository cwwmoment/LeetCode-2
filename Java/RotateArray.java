/*
 * LeetCode #189. Rotate Array
 * happygirlzt
 * Created on 27/07/2018
 */
import java.util.Arrays;

public class RotateArray {
	public static void rotate(int[] nums, int k) {
		// corner case
		if (nums == null || nums.length == 0) return;
		
		int len = nums.length;
		int[] tmp = Arrays.copyOf(nums, len);
		
		for (int i = 0; i < len; i++) {		
				nums[(i + k) % len] = tmp[i];  
		}

	}
	
	// reverse 3 times
	public static void rotate2(int[] nums, int k) {
		if (nums == null || nums.length == 0) return;
		
		int len = nums.length;
		k = k % len;
		
		reverse(nums, 0, len - k - 1);
		reverse(nums, len - k, len - 1);
		reverse(nums, 0, len - 1);
	}
	
	public static void reverse(int[] a, int i, int j) {
		while (i-- < j--) {
			int tmp = a[j];
			a[j] = a[i];
			a[i] = tmp;
		}
	}
	
	public static void main(String[] agrs) {
		int[] test = {1,2,3,4,5,6,7};
		int m = 3;
		
		rotate(test, m);
		
		for (int j = 0; j < test.length; j++) {
			System.out.println(j + "th is " + test[j]);
		}
	}
}
