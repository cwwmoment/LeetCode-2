/**
 * Created on 6 Jan 2019 by happygirlzt
 *
 * LeetCode #227. Basic Calculator II
 *
 */

class Solution {
    public int calculate(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        int num = 0;
        int res = 0;
        char sign = '+';

        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = 10 * num + (int) (c - '0');
            }

            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    st.push(num);
                } else if (sign == '-') {
                    st.push(-num);
                } else if (sign == '*') {
                    st.push(st.pop() * num);
                } else if (sign == '/') {
                    st.push(st.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }

        for (int i : st) {
            res += i;
        }

        return res;
    }
}
