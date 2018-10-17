
public class SearchInRotatedSortedArray {
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length < 1) return -1;
		
		for (int i = 0; i < nums.length; i++) {
			if (target == nums[i]) {
				return i;
			} else {
				if (i != nums.length - 1) {
					continue;
				} else {
					return -1;
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {4,5,6,7,0,1,2};
		System.out.println(search(a, 0));
	}
 }
