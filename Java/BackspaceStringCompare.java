/**
 * Created on 1 Mar 2019 by happygirlzt
 *
 * LeetCode #844. Backspace String Compare
 *
 */

class Solution {
    public boolean backspaceCompare(String S, String T) {
        if (S.isEmpty() && T.isEmpty()) return true;
        Deque<Character> st1 = new ArrayDeque<>();
        Deque<Character> st2 = new ArrayDeque<>();
        pushAll(S, st1);
        pushAll(T, st2);

        if (st1.size() != st2.size()) return false;
        while (st1.size() > 0) {
            if (st1.pop() != st2.pop()) return false;
        }

        return true;
    }

    private void pushAll(String s, Deque<Character> stack) {
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                stack.push(c);
            } else if (c == '#') {
                if (!stack.isEmpty()) stack.pop();
            }
        }
    }
}
