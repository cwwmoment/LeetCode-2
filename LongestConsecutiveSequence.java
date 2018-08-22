
/**
 * LeetCode #128. Longest Consecutive Sequence
 * 
 * @author happygirlzt
 *
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	// 失败的解法，Memory Limit Extended
	// 我是怎么想到dp的。。。想错了吧= =
	// 每次提前高兴，就总有坏事发生- - 根本不可能如人所愿！
	public static int longestConsecutive(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 0;

		int len = nums.length;
		Arrays.sort(nums);
		// System.out.println(len);
		int res = 1;

		int[][] dp = new int[len + 1][len + 1];
		for (int i = 0; i <= len; i++) {
			dp[i][i] = 1;
		}

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (nums[j - 1] + 1 == nums[j]) {
					dp[i + 1][j + 1] = dp[i + 1][j] + 1;
					// System.out.println("dp["+ (i + 1) + "][" + (j+1) + "] is " +dp[i + 1][j +
					// 1]);
					res = Math.max(res, dp[i + 1][j + 1]);
				} else if (nums[j - 1] == nums[j]) {
					dp[i + 1][j + 1] = dp[i + 1][j];
					res = Math.max(res, dp[i + 1][j + 1]);
				} else {
					// dp[i + 1][len] = dp[i + 1][j];
					// System.out.println("dp["+ (i + 1) + "][" + (j+1) + "] is " +dp[i + 1][j +
					// 1]);
					res = Math.max(res, dp[i + 1][j]);
					break;
				}
			}
		}

		return res;
	}

	// HashSet
	public static int longestConsecutive1(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		Set<Integer> set = new HashSet<>();
		Arrays.sort(nums);
		for (int i : nums) {
			set.add(i);
		}

		int count = 1, res = 1;
		Integer[] tmp = set.stream().toArray(n -> new Integer[n]);
		Arrays.sort(tmp);
		
		for (int i = 0; i < tmp.length; i++) {
			if (set.contains(tmp[i] + 1)) {
				count++;
			} else {
				res = Math.max(res, count);
				count = 1;
				continue;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		// int[] a = {9,1,4,7,3,-1,0,5,8,-1,6};
		int[] b = { 9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7 }; // 4
		int[] a = { 100, 4, 200, 1, 3, 2 };
        int[] d = {1,2,0,1};
		int[] c = { 0, 0 };
		System.out.println(longestConsecutive1(a));
	}
}
