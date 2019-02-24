/*
 * LeetCode # 22. Generate Parentheses
 * happygirlzt
 * Created on 2018-7-25
 * Backtracking
 */
import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();

        if (n < 0) return res;
        StringBuilder sb = new StringBuilder();

        helper(n, sb, res, 0, 0);
        return res;
    }

    public void helper(int n, StringBuilder sb, List<String> result, int l, int r) {
        // base case
        if (sb.length() == n * 2) {
            result.add(sb.toString());
            return;
        } else {
            // left
            if (l < n) {
                sb.append("(");
                helper(n, sb, result, l + 1, r);
                sb.setLength(sb.length() - 1);
            }

            // right
            if (r < l) {
                sb.append(")");
                helper(n, sb, result, l, r + 1);
                sb.setLength(sb.length() - 1);
            }
        }
    }

    // Updated on 24 Feb 2019
    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        helper(res, n, n, new StringBuilder());
        return res;
    }
    
    private void helper(List<String> res, int left, int right, StringBuilder cur) {
        int len = cur.length();
        if (left > right || left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            res.add(cur.toString());
            return;
        }
        
        cur.append('(');
        helper(res, left - 1, right, cur);
        cur.setLength(len);
        cur.append(')');
        helper(res, left, right - 1, cur);
        cur.setLength(len);
    }
}
