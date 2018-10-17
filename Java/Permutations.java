
/**
 * LeetCode #46. Permutations
 * 
 * Created by happygirlzt on 30 Aug 2018 at 6:23:21 PM
 *
 */
import java.util.List;
import java.util.ArrayList;

/**
 * Input is distinct
 * Input: [1,2,3] Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]
 * ]
 *
 */

public class Permutations {
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, new ArrayList<>(), nums);

		return res;
	}

	public static void backtrack(List<List<Integer>> res, ArrayList<Integer> tmp, int[] nums) {
		if (tmp.size() == nums.length) {
			res.add(new ArrayList<>(tmp));
			return;
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tmp.contains(nums[i]))
					continue;
				tmp.add(nums[i]);
				backtrack(res, tmp, nums);
				tmp.remove(tmp.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		permute(a);

		System.out.println(permute(a));
	}
}
