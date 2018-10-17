
/* 
 * 2018-07-19 
 * 
 * LeetCode #136
 */

import java.util.Set;
import java.util.HashSet;

public class SingleNumber {
	// Solution 1: HashSet
	public int solution(int[] nums) {
		Set<Integer> s = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (s.add(nums[i]) == false) {
				s.remove(nums[i]);
			}
		}

		Integer[] res = s.toArray(new Integer[1]);
		return res[0];
	}
	
	// Solution 2: ^
	public static int solution2(int[] nums) {
		int res = 0;
		
		for (int i = 0; i < nums.length; i++) {
			res = nums[i] ^ res;
			// System.out.println("The " + i + "th is " + res);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] b = {2, 2, 1};
		System.out.println(solution2(b));
		
	}
}