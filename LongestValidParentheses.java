/*
 * LeetCode #32. Longest Valid Parentheses
 * happygirlzt
 * Created on 27/07/2018
 */
import java.util.Stack;
import java.util.HashMap;

public class LongestValidParentheses {
	public static int longestValidParentheses(String s) {
		Stack<Character> st = new Stack<>();
		
		int res = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				st.push(c);
			} else {
				if (!st.empty() && st.peek() == '(') {
					st.pop();
					res += 2;
				} else {
					st.push(c);
				}
			}
		}
		
		return res;
	}
	
	public static int longestValidParentheses2(String s) {

		int len = 0;
		
		Stack<Integer> st = new Stack<>();
		
		st.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				st.push(i);
			} else {
				st.pop();
				if (st.empty()) {
					st.push(i);
				} else {
					len = Math.max(len, i - st.peek());
				}
 			}
		}
		return len;
	}
	public static void main(String args[]) {
		String test = "()(()";
		System.out.println(longestValidParentheses2(test));
	}
}
