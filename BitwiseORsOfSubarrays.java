
/**
 * 
 * Created by happygirlzt on 2 Sep 2018 at 9:58:44 AM
 *
 */

import java.util.HashSet;

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
		HashSet<Integer> res = new HashSet<>();
		HashSet<Integer> nxt = new HashSet<>();

		for (Integer i : a) {
			HashSet<Integer> cur = new HashSet<>();
			cur.add(i);
			res.add(i);
			for (Integer j : nxt) {
				cur.add(j|i);
				res.add(j|i);
			}		
			
			nxt = cur;
		}

		return res.size();
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 4 };
		System.out.println(subarrayBitwiseORs(nums));
	}
}
