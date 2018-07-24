/*
 * LeetCode #17. Letter Combinations of a Phone Number
 * happygirlzt
 * 2018/7/24
 * dfs
 */
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.lang.StringBuilder;

public class LetterCombinationsOfPhoneNumber {
	public static List<String> letterCombinations(String digits) {
		// corner case
		if (digits == null || digits.length() == 0) return null;
		
		List<String> res = new LinkedList<>();
		
		HashMap<Integer, String> map = new HashMap<>();
		
		map.put(0, "");
		map.put(1, "");
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");

		StringBuilder sb = new StringBuilder();
		// dfsHelper()
		dfsHelper(digits, 0, map, sb, res);
		return res;
	}

	public static void dfsHelper(String s, int index, HashMap<Integer, String> map, StringBuilder sb, List<String> res) {
		// base case
		if (index == s.length()) {
			res.add(sb.toString());
			return;
		}
		
		// recursive case
		char ch = s.charAt(index);
		String values = map.get(ch - '0');
		for (char c : values.toCharArray()) {
			sb.append(c);
			dfsHelper(s, index + 1, map, sb, res);
			// recover
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	public static void main(String[] args) {
		String test = "23";
		System.out.println(letterCombinations(test));
	}
}
