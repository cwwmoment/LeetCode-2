/**
 * Created on 24 Apr 2019 by happygirlzt
 *
 * LeetCode #1021. Remove Outermost Parentheses
 *
 */

class Solution {
    public String removeOuterParentheses(String S) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c == '(' && count++ > 0) {
                sb.append('(');
            } else if (c == ')' && --count > 0) {
                sb.append(')');
            }
        }

        return sb.toString();
    }
}
