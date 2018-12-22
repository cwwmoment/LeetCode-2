/**
 * Created on 22 Dec 2018 by happygirlzt
 *
 * LeetCode #544. Output Contest Matches
 *
 */

class Solution {
    public String findContestMatch(int n) {
        StringBuilder sb = new StringBuilder();
        helper(sb, 3, n, 1);
        return sb.toString();
    }

    private void helper(StringBuilder sb, int sum, int n, int val) {
        // base case
        if (sum > n + 1) {
            sb.append(val);
            return;
        } else {
            sb.append('(');
            helper(sb, sum * 2 - 1, n, val);
            sb.append(',');
            helper(sb, sum * 2 - 1, n, sum - val);
            sb.append(')');
        }

    }
}
