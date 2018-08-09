/*
 * LeetCode #88. Merge Sorted Array
 * happygirlzt
 * Created on 27/07/2018
 */
import java.util.Arrays;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int i = m; i < m + n; i ++) {
			nums1[i] = nums2[i-m];
		}
		
		Arrays.sort(nums1);
	}
	
	public void merge2(int[] a, int m, int[] b, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		
		while (i >= 0 && j >= 0 && k >= 0) {
			if (a[i] > b[j]) {
				a[k--] = a[i--];
			} else {
				a[k--] = b[j--];
			}
		}
		
		while (n >= 0) {
			a[k--] = b[j--];
		}
	}
}
