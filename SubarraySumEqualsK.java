
/*
 * LeetCode #560. Subarray Sum 	Equals K
 * @happygirlzt
 * Created on 18 Aug 2018
 */

import java.util.HashMap;

public class SubarraySumEqualsK {
	// Time Limit Extended... Wrong solution
	public static int subarraySum(int[] nums, int k) {
		int res = 0;
		if (nums.length == 0)
			return res;

		HashMap<String, Integer> sums = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int tmp = nums[i];
			if (tmp == k)
				res++;
			for (int j = i + 1; j < nums.length; j++) {
				tmp += nums[j];
				sums.put(Character.toString((char) i) + Character.toString((char) j), tmp);
				if (tmp == k)
					res++;
				continue;
			}
		}

		// res += Collections.frequency(new ArrayList<Integer>(sums.values()),
		// k);
		return res;
	}

	public static int subarraySum1(int[] nums, int k) {
		// The sum is key, the frequency is value
		HashMap<Integer, Integer> preSum = new HashMap<>();
		int res = 0;
		int sum = 0;
		// 0 occurs once
		preSum.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (preSum.containsKey(sum - k)) {
				res += preSum.get(sum - k);
			}

			if (!preSum.containsKey(sum)) {
				preSum.put(sum, 1);
			} else {
				int tmp = preSum.get(sum);
				preSum.put(sum, tmp++);
			}

			// preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] a = { -1, -1, 2 };

		System.out.println(subarraySum1(a, 0));
	}
}
