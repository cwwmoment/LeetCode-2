/**
 * Created on 27 Dec 2018 by happygirlzt
 *
 * LeetCode #739. Daily Temperatures
 *
 */

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && T[st.peek()] <= T[i]) {
                st.pop();
            }

            res[i] = st.isEmpty() ? 0 : st.peek() - i;
            st.push(i);
        }
        return res;
    }
}
