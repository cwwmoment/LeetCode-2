/**
 * Created on 12 Jan 2019 by happygirlzt
 *
 * LeetCode #503. Next Greater Element II
 *
 */

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i % n]) {
                st.pop();
            }

            res[i % n] = st.isEmpty() ? -1 : nums[st.peek()];

            st.push(i % n);
        }

        return res;
    }
}
