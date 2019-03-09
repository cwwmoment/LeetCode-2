/**
 * Created on 30 Dec 2018 by happygirlzt
 *
 * LeetCode #71. Simplify Path
 *
 */

class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        Deque<String> st = new ArrayDeque<>();

        for (String str: path.split("/")) {
            if (str.equals("..")) {
                st.poll();
            } else if (!str.equals(".") && !str.equals("")) {
                st.push(str);
            }
        }

        if (st.size() == 0) return "/";
        StringBuilder sb = new StringBuilder();
        while (st.size() != 0) {
            sb.append("/").append(st.pollLast());
        }

        return sb.toString();
    }

    // Updated on 28 Feb 2019
    // bidirectional-queue, which is deque
    // .., pop(), finally, poll()
    // removeLast(), removeFirst(), addLast()
    public String simplifyPath1(String path) {
        if (path == null || path.length() == 0) return "";
        Deque<String> q = new ArrayDeque<>();
        for (String s : path.split("/")) {
            if (s.equals("..")) {
                if (!q.isEmpty()) q.pollLast();
            } else if (!s.equals(".") && !s.equals("")) {
                q.offer(s);
            }
        }

        if (q.size() == 0) return "/";
        StringBuilder sb = new StringBuilder();
        while (q.size() > 0) {
            sb.append("/");
            sb.append(q.poll());
        }

        return sb.toString();
    }
}
