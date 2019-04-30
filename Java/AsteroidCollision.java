/**
 * Created on 30 Apr 2019 by happygirlzt
 *
 * LeetCode #735. Asteroid Collision
 *
 */

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int a : asteroids) {
            if (stack.isEmpty() || a * stack.peek() > 0 || stack.peek() < 0 && a > 0) {
                stack.push(a);
            } else {
                boolean flag = true;
                while (!stack.isEmpty() && stack.peek() * a < 0) {
                    if (Math.abs(stack.peek()) == Math.abs(a)) {
                        stack.pop();
                        flag = false;
                        break;
                    } else if (Math.abs(stack.peek()) < Math.abs(a)) {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }

                if (flag) stack.push(a);
            }
        }

        int n = stack.size();
        int[] res = new int[n];
        int index = n - 1;
        while (!stack.isEmpty()) {
            res[index--] = stack.pop();
        }

        return res;
    }
}
