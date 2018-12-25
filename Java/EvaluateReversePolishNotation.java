/**
 * Created on 25 Dec 2018 by happygirlzt
 *
 * LeetCode #150. Evaluate Reverse Polish Notation
 *
 */

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String s: tokens) {
            if (s.equals("+") || s.equals("-") ||
                s.equals("*") || s.equals("/")) {
                if (s.equals("+")) {
                    st.push(st.pop() + st.pop());
                } else if (s.equals("-")) {
                    st.push(- st.pop() + st.pop());
                } else if (s.equals("*")) {
                    st.push(st.pop() * st.pop());
                } else {
                    int left = st.pop();
                    int right = st.pop();
                    st.push(right / left);
                }
            } else {
                st.push(Integer.parseInt(s));
            }
        }

        return st.peek();
    }
}
