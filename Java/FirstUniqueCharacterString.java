/*
 * LeetCode # 387. First Unique Character in a String
 * happygirlzt
 * Created on 2018-7-31
 */
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class FirstUniqueCharacterString {
	public static int firstUniqChar(String s) {
		// corner case
		if (s == null || s.length() < 1) {
			return -1;
		}

		if (s.length() == 1)
			return 0;

		int i = -1;

		Set<Character> set = new HashSet<>();
		Map<Character, Integer> map = new HashMap<>();

		for (int j = 0; j < s.length(); j++) {
			if (set.add(s.charAt(j))) {
				map.put(s.charAt(j), j);
			} else {
				if (map.containsKey(s.charAt(j))) {
					map.remove(s.charAt(j));
				}
			}
		}


		if (map.size() == 0) {
			return -1;
		} else {
			i = s.length() - 1;
			for (Map.Entry<Character, Integer> entry : map.entrySet()) {
				int tmp = entry.getValue();
				// System.out.println("min = " + tmp);
				i = Math.min(tmp, i);
				// System.out.println("i = " + i);
			}
		}
		return i;
	}
	
	public static int firstUniqChar2(String s) {
		char[] c = new char[26];
		
		for (char ch : s.toCharArray()) {
			c[ch - 'a'] ++;
		}
		
		for (int i = 0; i < s.length(); i++) {
			if (c[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		
		return -1;
	}
	public static void main(String[] args) {
		String s = "loveleetcode";
		System.out.println(firstUniqChar(s));
	}
}
