/*
 * LeetCode #16 3Sum Closest
 * happygirlzt
 * 2018/7/23
 */

import java.util.Arrays;
import java.util.HashSet;

import java.util.Collections;

import java.util.HashMap;

public class ThreeSumClosest {
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		HashSet<Integer> set = new HashSet<Integer>();

		int res = 0;
		for (int i = 0; i < nums.length; i++) {

			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				if (nums[i] + nums[j] + nums[k] == target) {
					return target;
				} else if (nums[i] + nums[j] + nums[k] < target) {
					set.add(nums[i] + nums[j] + nums[k]);
					j++;
				} else {
					set.add(nums[i] + nums[j] + nums[k]);
					k--;
				}
			}
		}

		System.out.println(set);

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : set) {
			map.put(i, Math.abs(target - i));
		}

		Integer min = Collections.min(map.values());

		for (Integer key : map.keySet()) {
			if (map.get(key) == min) {
				return key;
			}
		}

		return res;
	}

	// a little bit improvement
	public static int solution2(int[] nums, int target) {
		Arrays.sort(nums);

		int res = nums[0] + nums[1] + nums[nums.length-1];
		for (int i = 0; i < nums.length; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				
				if (sum == target) {
					return target;
				} else if (sum < target) {
					start++;
				} else {
					end--;
				}
				
				if (Math.abs(sum - target) < Math.abs(res - target)) {
					res = sum;
				}
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		int[] a = { -1, 2, 1, -4 };

		System.out.println(threeSumClosest(a, 1));
		System.out.println(solution2(a, 1));
	}
}
