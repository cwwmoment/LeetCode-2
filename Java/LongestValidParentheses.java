/**
 * LeetCode #32. Longest Valid Parentheses
 * happygirlzt
 * Created on 27/07/2018
 */

public class LongestValidParentheses {
    public static int longestValidParentheses2(String s) {
        int len = 0;
        Deque<Integer> st = new ArrayDeque<>();

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

    // Updated on 26 Feb 2019
    // Dynamic Programming
    // dp[i] represents the length of longest valid parentheses end
    // here
    public int longestValidParentheses1(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int max = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i > 2) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    if (i - dp[i - 1] >= 2) {
                        dp[i] = dp[i - dp[i - 1] - 2] + dp[i - 1] + 2;
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }

                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }
}
