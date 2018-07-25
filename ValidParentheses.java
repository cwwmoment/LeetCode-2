/*
 * LeetCode # 20. Valid Parentheses
 * happygirlzt
 * Created on 2018-7-25
 */
import java.util.Stack;
import java.util.HashMap;

public class ValidParentheses {

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		boolean result;
		HashMap<Character, Character> map = new HashMap<>();
		map.put('[', ']');
		map.put('{', '}');
		map.put('(', ')');

		for (char c : s.toCharArray()) {
			if (c == '[' || c == '{' || c == '(') {
				stack.push(c);
				// System.out.println("Push " + c);
				continue;
			}

			if (!stack.isEmpty()) {
				if (map.get(stack.peek()) == c) {
					// System.out.println("The peek is " + c);
					stack.pop();
					// System.out.println("Pop " + c);
				} else {
					return false;
				}
			} else {
				return false;
			}
		}

		if (stack.isEmpty()) {
			result = true;
		} else {
			result = false;
		}

		return result;
	}

	public static void main(String[] args) {
		String test = "(])";
		System.out.println(isValid(test));
	}
}
