/**
 * LeetCode #84. Largest Rectangle in Histogram
 * @happygirlzt Created on 19 Aug 2018
 *
 */
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        int tp = 0; // the peek of the stack

        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length ? 0 : heights[i]);
            if (stack.isEmpty() || heights[stack.peek()] <= h) {
                stack.push(i); // push the index
            } else {
                tp = stack.peek();
                stack.pop();

                maxArea = Math.max(maxArea, heights[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                i--;
            }
        }

        return maxArea;
    }

    public static int largestRectangleArea1(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

}
