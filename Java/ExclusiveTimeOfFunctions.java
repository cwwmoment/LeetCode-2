/**
 * Created on 22 Feb 2019 by happygirlzt
 *
 * LeetCode #636. Exclusive Time of Functions
 */

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Integer> stack = new ArrayDeque<>();
        String[] s = logs.get(0).split(":");
        stack.push(Integer.valueOf(s[0]));
        int prev = Integer.valueOf(s[2]);
        int[] res = new int[n];

        for (int i = 1; i < logs.size(); i++) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty()) res[stack.peek()] += Integer.valueOf(s[2]) - prev;
                stack.push(Integer.valueOf(s[0]));
                prev = Integer.valueOf(s[2]);
            } else {
                res[stack.pop()] += Integer.valueOf(s[2]) - prev + 1;
                prev = Integer.valueOf(s[2]) + 1;
            }
        }

        return res;
    }
}
