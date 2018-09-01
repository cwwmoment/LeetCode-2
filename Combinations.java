
/**
 * LeetCode #77. Combinations
 * 
 * Created by happygirlzt on 1 Sep 2018 at 8:30:27 PM
 *
 */

import java.util.List;
import java.util.ArrayList;

/**
 * Input: n = 4, k = 2 Output: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 *
 */

// TODO
public class Combinations {
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (n == 0 || k == 0) {
			return res;
		}

		backtrack(res, new ArrayList<Integer>(), n, k, 0);
		return res;
	}

	public static void backtrack(List<List<Integer>> res, List<Integer> tmp, int n, int k, int cur) {
		if (tmp.size() == k && !res.contains(tmp)) {
			res.add(new ArrayList<>(tmp));
		}

		for (int i = cur; i < k; i++) {
			for (int j = 1; j <= n; j++) {
				if (tmp.add(j)) {
					System.out.println("Added " + tmp);
					backtrack(res, tmp, n, k, ++cur);
					tmp.remove(tmp.size() - 1);
					cur--;
				} else {
					j++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		List<List<Integer>> res = combine(4, 2);
		System.out.println(res);
	}
}
