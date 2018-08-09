
public class SearchInsertPosition {
	public static int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0) return 0;
		if (target > nums[nums.length - 1]) return nums.length;
		if (target < nums[0]) return 0;
		if (target == nums[0]) return 0;
		
		int left = 0;
		int right = nums.length - 1;
		int mid = (left + right) / 2;
		
		// System.out.println(mid);
		while (target != nums[mid]) {
			if (target < nums[mid]) {
				if (left + 1 == mid) {
					return mid;
				} else {
				right = mid;
				mid = (left + right) / 2;
				// System.out.println(mid);
				}
			} else {
				if (mid + 1 == right) {
					return mid + 1;
				} else {
				left = mid;
				mid = (left + right) / 2;
				// System.out.println(mid);
				}
			}
		}
		
		return mid;
	}
	
	public static void main(String[] args) {
		int[] a = {1,3,5,6};
		System.out.println(searchInsert(a, 2));
	}
}
