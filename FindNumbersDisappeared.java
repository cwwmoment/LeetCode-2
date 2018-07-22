import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class FindNumbersDisappeared {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			set.add(nums[i]);
		}
		
		for (int j = 1; j <= len; j++) {
			if (set.contains(j)) {
				set.remove(j);
			} else {
				res.add(j);
			}
		}
		
		return res;
	}
}
