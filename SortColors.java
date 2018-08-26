/*
 * LeetCode # 75. Sort Colors
 * Created by happygirlzt
 * on 2018-7-26
 */

public class SortColors {
	
	public void sortColors(int[] nums) {
		
		if (nums.length == 0 || nums == null) return;
		
		// int[] tmp = new int[nums.length];
		
		int n_0 = 0;
		int n_1 = 0;
		int n_2 = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				n_0 ++;
			} else if (nums[i] == 1) {
				n_1 ++;
			} else {
				n_2 ++;
			}
		}
		
		for (int j = 0; j < nums.length; j++) {
			if (j < n_0) {
				nums[j] = 0;
			} else if (j < n_1) {
				nums[j] = 1;
			} else {
				nums[j] = 2;
			}
		}		
	}
	
	public static void sortColors2(int[] nums) {
		if (nums.length <= 1 || nums == null) return;
		
		int i = 0;  // wall between 0 and 1
		int j = i;  // the current value, wall between 1 and unchecked
		int k = nums.length - 1;  // wall between unchecked and 2 
		
		while (j <= k) {
			if (nums[j] == 0) {
				swap(nums, i++, j++);
				// System.out.println("Before " + nums[j]);
			} else if (nums[j] == 1) {
				j++;
				// System.out.println("Before 1" + nums[j]);
			} else if (nums[j] == 2) {
				swap(nums, j, k--);
				// System.out.println("When nums[j] == 2 " + nums[j]);
			}
		}
	}
	
	public static void swap(int[] num, int i, int j) {
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
	
	public static void main(String[] agrs) {
		int[] test = {2,0,2,1,1,0};
		
		sortColors2(test);
		
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}

	}
}
