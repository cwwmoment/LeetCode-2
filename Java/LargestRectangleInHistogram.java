/**
 * LeetCode #84. Largest Rectangle in Histogram
 *
 * Created by happygirlzt on 11 Apr 2019
 *
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        int curIndex = 0;
        int n = heights.length;
        stack.push(-1);

        while (curIndex < n) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[curIndex]) {
                max = Math.max(max, heights[stack.pop()] * (curIndex - stack.peek() - 1));
            }

            stack.push(curIndex++);
        }

        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (n - stack.peek() - 1));
        }

        return max;
    }
}
