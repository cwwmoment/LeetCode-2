
public class MedianOfTwoSortedArray {
	public static int[] merge(int[] a1, int[] a2) {
		int[] merged = new int[a1.length+a2.length];
		
		int i = 0, j = 0, k = 0;
		while(i < a1.length && j < a2.length) {
			merged[k++] = (a1[i] < a2[j]) ? a1[i++] : a2[j++]; 
		}
		
		while(i < a1.length) {
			merged[k++] = a1[i++];
		}
		
		while(j < a2.length) {
			merged[k++] = a2[j++];
		}
		// System.out.println(Arrays.toString(merged));
		return merged;
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double res = 0.0;
		int[] m = merge(nums1, nums2);
		int n = m.length;
		if (n % 2 == 0) {
			res = (m[n/2] + m[(n-1)/2])/2.0;
		} else {
			res = m[n/2];
		}
		
		return res;
	}
	
	public static void main(String[] agrs) {
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
