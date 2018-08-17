/*
 * LeetCode #167. Two Sum II - Input array is sorted
 * happygirlzt
 * Created on 16 Aug 2018
 */

import java.util.HashMap;

public class TwoSum2 {
	// HashMap
	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				return new int[]{map.get(target - numbers[i]) + 1, i + 1};
			} else {
				map.put(numbers[i], i);
			}
		}
		
		return new int[]{0, 0};
	}
	
	// Two pointers
	public int[] twoSum2(int[] nums, int target) {
		int i = 0;
		int j = nums.length - 1;
		
		while (i < j) {
			int sum = nums[i] + nums[j];
			
			if (sum == target) {
				return new int[]{i + 1, j + 1};
			} else if (sum < target) {
				i ++;
			} else {
				j --;
			}
		}
		
		return new int[]{0, 0};
	}
}
