/* 算法：
 * 用字符串每一个字符的索引当做key，然后算出以每个字符当做起点最长的不重复的字串，取出hashmap中最大的value
 * 即是结果
 */

import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;

public class LongestSubstring {
	// Solution 1
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) return 0;
		
		int res = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (int i = 0, j = 0; i < s.length(); ) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(j))+ 1);
			}
			
			map.put(s.charAt(i), i);
			
			res = Math.max(res, i - j + 1);
			
			return res;
		}
		
		return res;
	}
	
	// Solution 2
	public static int solution2(String s) {
		if (s == null || s.length() == 0) return 0;
		
		int r = 0;	
		HashSet<Character> set = new HashSet<>();
		
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				set.remove(s.charAt(j));
				// set.add(s.charAt(i));
				j++;
			} else {
				set.add(s.charAt(i));
				r = Math.max(r, set.size());
			}
		}
		return r;
	}

	public static int solution3(String s) {
		int i = 0, j = 0, max = 0;
	    Set<Character> set = new HashSet<>();
	    
	    while (j < s.length()) {
	        if (!set.contains(s.charAt(j))) {
	            set.add(s.charAt(j++));
	            max = Math.max(max, set.size());
	        } else {
	            set.remove(s.charAt(i++));
	        }
	    }
	    
	    return max;
	}
	public static void main(String[] args) {
		String str = "qrsvbspk";

		System.out.println(solution3(str));
	}
}
