/**
 * Created on 11 Feb 2019 by happygirlzt
 * 
 * LeetCode #772. Basic Calculator III
 */

class Solution {
    public int calculate(String s) {
        Deque<Character> ops = new ArrayDeque<>();
        Deque<Integer> vals = new ArrayDeque<>();
        
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') {
                    vals.push(applyOp(ops.pop(), vals.pop(), vals.pop()));
                }
                ops.pop();
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + (int) (c - '0');
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
    
    
    private boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        } else {
            return true;
        }
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
                    throw new UnsupportedOperationException("Cannot");
                }
                return a / b;
        }
        return 0;
    }
}