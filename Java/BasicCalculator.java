/**
 * Created on 6 Jan 2019 by happygirlzt
 *
 * LeetCode #224. Basic Calculator
 *
 */

class Solution {
    public int calculate(String s) {
        int res = 0;
        int num = 0, sign = 1;

        Deque<Integer> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = 10 * num + (int) (c - '0');
            } else if (c == '+') {
                res += num * sign;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                res += num * sign;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                st.push(res);
                st.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * num;
                num = 0;
                res = res * st.pop() + st.pop();
            }
        }

        if (num != 0) res += num * sign;
        return res;
    }
}
