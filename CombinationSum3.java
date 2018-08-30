/**
 * LeetCode #216. Combination Sum III
 * 
 * Created by happygirlzt on 30 Aug 2018 at 10:31:57 AM
 *
 */
import java.util.List;
import java.util.ArrayList;

public class CombinationSum3 {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, new ArrayList<>(), k, 1, n);
		
		return res;
	}
	
	public void backtrack(List<List<Integer>> res, ArrayList<Integer> tmp, int k, int start, int n) {
		if (tmp.size() == k && n == 0) {
			res.add(new ArrayList<>(tmp));
			return;
		}
		
		for (int i = start; i <= 9; i++) {
			tmp.add(i);
			backtrack(res, tmp, k, i + 1, n - i);
			tmp.remove(tmp.size() - 1);
		}
	}
}
