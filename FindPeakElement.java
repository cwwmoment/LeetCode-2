/**
 * LeetCode 162. Find Peak Element
 * 
 * @author happygirlzt
 *
 */
public class FindPeakElement {
	public static int findPeakElement(int[] nums) {
		
		int left = 0, right = nums.length - 1;
		while (left < right) {
			if (nums[left] < nums[left + 1]) {
				left++;
			} else if (nums[left] > nums[left + 1]){
				return left;
			}
			
			if (nums[right] < nums[right - 1]) {
				right--;
			} else if (nums[right] > nums[right - 1]) {
				return right;
			}
		}
		
		return left;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 1};
		
		System.out.println(findPeakElement(a));
	}
}
