import java.util.Stack;

/**
 * LeetCode 42. Trapping Rain Water
 * 
 * @happygirlzt Created on 19 Aug 2018
 */
public class TrappingRainWater {

	// Solution 0: Naive
	public static int trap(int[] height) {
		int maxArea = 0;
		if (height == null || height.length == 0)
			return maxArea;

		int[] leftHighest = new int[height.length + 1];
		leftHighest[0] = 0;

		for (int i = 0; i < height.length; i++) {
			leftHighest[i + 1] = Math.max(leftHighest[i], height[i]);
		}

		int rightHighest = 0;
		for (int j = height.length - 1; j > 0; j--) {
			rightHighest = Math.max(rightHighest, height[j]);
			int min = Math.min(leftHighest[j], rightHighest);
			maxArea += (min > height[j]) ? min - height[j] : 0;
		}

		return maxArea;
	}

	// Solution 1: Two Pointers
	public static int trap1(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int i = 0, j = height.length - 1;
		int leftMax = height[i], rightMax = height[j];
		int maxArea = 0;

		while (i < j) {
			if (height[i] < height[j]) {
				leftMax = Math.max(height[i], leftMax);
				maxArea += leftMax - height[i];
				i++;
			} else {
				rightMax = Math.max(height[j], rightMax);
				maxArea += rightMax - height[j];
				j--;
			}
		}

		return maxArea;
	}

	// Solution 2: Stack
	public static int trap2(int[] height) {
		if (height == null || height.length == 0)
			return 0;

		int maxArea = 0;
		Stack<Integer> st = new Stack<>();
		int i = 0;
		while (i < height.length) {
			if (st.isEmpty() || height[i] <= height[st.peek()]) {
				st.push(i++);
			} else {
				// TODO: Think it over
				int bar = st.pop();
				int tmp = st.isEmpty() ? 0
						: (Math.min(height[st.peek()], height[i]) - height[bar]) * (i - st.peek() - 1);

				maxArea += tmp;
			}
		}

		return maxArea;
	}

	public static void main(String[] args) {
		int[] a = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap2(a));
	}
}
