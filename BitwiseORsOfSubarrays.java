
/**
 * 
 * Created by happygirlzt on 2 Sep 2018 at 9:58:44 AM
 *
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Input: [1,1,2] Output: 3 Explanation: The possible subarrays are [1], [1],
 * [2], [1, 1], [1, 2], [1, 1, 2]. These yield the results 1, 1, 2, 1, 3, 3.
 * There are 3 unique values, so the answer is 3.
 */
public class BitwiseORsOfSubarrays {

// 先求出int[] a 的各种组合。然后求他们的异或，把值存到hashset中，
// 最终hashset的大小就是最后的结果
// 注意一下题目，是subarray不是。。所有数字的组合

	public static int subarrayBitwiseORs(int[] a) {
		if (a.length == 0 || a == null)
			return 0;

		HashSet<Integer> res = new HashSet<>();
		List<List<Integer>> lists = new ArrayList<>();
		backtrack(lists, a);

		for (List<Integer> list : lists) {
			System.out.println(list);
			int sum = list.get(0);
			for (int i = 1; i < list.size(); i++) {
				sum = sum | list.get(i);
			}
			System.out.println("Sum is " + sum);
			res.add(sum);
		}

		return res.size();
	}

	// 以每个点为起点，分别求出长度为1...i-1的subarray，存到lists当中
	public static void backtrack(List<List<Integer>> lists, int[] nums) {
		for (int j = 1; j <= nums.length; j++) {
			ArrayList<Integer> tmp = new ArrayList<>();
			for (int i = j - 1; i < nums.length; i++) {
				tmp.add(nums[i]);
				lists.add(new ArrayList<>(tmp));
				
				if (tmp.size() == j)
					tmp.remove(tmp.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 4 };
		System.out.println(subarrayBitwiseORs(nums));
	}
}
