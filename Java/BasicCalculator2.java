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

    // Updated on 11 Feb 2019, two stacks
    public int calculate1(String s) {
        Deque<Character> ops = new ArrayDeque<>();
        Deque<Integer> vals = new ArrayDeque<>();

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c >= '0' && c <= '9') {
                num = (int) (c - '0');
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (int) (s.charAt(++i) - '0');
                }
                vals.push(num);
                num = 0;
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && hasPrecedence(c, ops.peek())) {
                    vals.push(applyOp(ops.pop(), vals.pop(), vals.pop()));
                }

                ops.push(c);
            }
        }

        while (!ops.isEmpty()) {
            vals.push(applyOp(ops.pop(), vals.pop(), vals.pop()));
        }

        return vals.pop();
    }

    // op2 has precedence than op1
    private boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }

        return true;
    }

    private int applyOp(char op, int b, int a) {
        switch (op) {
        case '+' :
            return a + b;
        case '-' :
            return a - b;
        case '*' :
            return a * b;
        case '/' :
            if (b == 0) {
                throw new UnsupportedOperationException("hello");
            }
            return a / b;
        }
        return 0;
    }


    public int calculate2(String s) {
        int n = s.length();
        int result = 0;
        int tail = 0;
        char operator = '+';
        char[] chars = s.toCharArray();
        for(int i = 0; i < n; ) {
            if (chars[i] == ' ') {
                ++i;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                int num = 0;
                int j = i;
                while(j < n && chars[j] >= '0' && chars[j] <= '9') {
                    num = num * 10 + chars[j] - '0';
                    ++j;
                }
                i = j;
                switch(operator) {
                case '+':
                    result += tail;
                    tail = num;
                    break;
                case '-':
                    result += tail;
                    tail = -num;
                    break;
                case '*':
                    tail *= num;
                    break;
                case '/':
                    tail /= num;
                    break;
                }
            } else { // + - * /
                operator = chars[i++];
            }
        }
        return result + tail;
    }
}
