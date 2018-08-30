
/**
 * LeetCode #47. Permutations II
 * 
 * Created by happygirlzt on 30 Aug 2018 at 6:48:06 PM
 *
 */
import java.util.List;
import java.util.ArrayList;

public class Permutations2 {
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, new ArrayList<>(), nums);

		return res;
	}

	public static void backtrack(List<List<Integer>> res, ArrayList<Integer> tmp, int[] nums) {
		if (tmp.size() == nums.length) {
			if (!res.contains(tmp)) {
				res.add(new ArrayList<>(tmp));
			}
		} else {
			for (int i = 0; i < nums.length; i++) {
				tmp.add(nums[i]);
				backtrack(res, tmp, nums);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,1,2};
		System.out.println(permuteUnique(a));
	}
}
