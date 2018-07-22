
public class MedianOfTwoSortedArray {
	
	public static double getMiddle(int[] a) {
		int len = a.length;
		double res = 0.0;
		if (len == 0) return 0;
		
		if (len % 2 != 0) {
			return a[len/2];
		} else {
			res = (a[len/2] * 1.0 +a[len/2-1] * 1.0) /2;

			return res;
		}
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0) {
			return getMiddle(nums2);
		}
		
		if (nums2.length == 0) {
			return getMiddle(nums1);
		}
		
		double mid1 = getMiddle(nums1);
		double mid2 = getMiddle(nums2);
		
		double res = (mid1 + mid2) / 2;

		return res;
	}
	
	public static void main(String[] agrs) {
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
