/**
 * Created on 27 Oct 2018 by happygirlzt
 *
 * LeetCode #301. Remove Invalid Parentheses
 *
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int rmL = 0, rmR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rmL++;
            } else if (s.charAt(i) == ')') {
                if (rmL != 0) {
                    rmL--;
                } else {
                    rmR++;
                }
            }
        }

        Set<String> res = new HashSet<>();
        dfs(s, 0, res, new StringBuilder(), rmL, rmR, 0);
        return new ArrayList<String>(res);
    }

    public void dfs(String s, int i, Set<String> res, StringBuilder sb, int rmL, int rmR, int open) {
        if (rmL < 0 || rmR < 0 || open < 0) {
            return;
        }

        if (i == s.length()) {
            if (rmL == 0 && rmR == 0 && open == 0) {
                res.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(i);
        int len = sb.length();

        if (c == '(') {
            dfs(s, i + 1, res, sb, rmL - 1, rmR, open);
            dfs(s, i + 1, res, sb.append(c), rmL, rmR, open + 1);

        } else if (c == ')') {
            dfs(s, i + 1, res, sb, rmL, rmR - 1, open);
            dfs(s, i + 1, res, sb.append(c), rmL, rmR, open - 1);

        } else {
            dfs(s, i + 1, res, sb.append(c), rmL, rmR, open);
        }

        sb.setLength(len);
    }

    // Updated on 31 Jan 2019
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            res.add("");
            return res;
        }

        Queue<StringBuilder> q = new LinkedList<>();
        // Set<StringBuilder> visited = new HashSet<>();
        Set<String> visited = new HashSet<>();
        q.offer(new StringBuilder(s));
        visited.add(s);
        // visited.add(new StringBuilder(s));

        boolean seen = false;
        while (!q.isEmpty()) {
            StringBuilder cur = q.poll();

            if (isValid(cur.toString())) {
                res.add(cur.toString());
                seen = true;
            }

            if (seen) continue;
            for (int j = 0; j < cur.length(); j++) {
                if (cur.charAt(j) != '(' && cur.charAt(j) != ')') continue;

                StringBuilder modified = new StringBuilder(cur);
                modified.deleteCharAt(j);
                /* bug
                   if (!visited.contains(modified)) {
                   visited.add(modified);
                   q.offer(modified);
                   }
                */
                if (!visited.contains(modified.toString())) {
                    visited.add(modified.toString());
                    q.offer(modified);
                }
            }
        }

        return res;
    }

    private boolean isValid(String s) {
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            if (c == ')' && open-- == 0) return false;
        }

        return open == 0;
    }
}
