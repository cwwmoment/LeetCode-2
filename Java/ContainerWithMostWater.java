/*
 * LeetCode #11 Container With Most Water
 * 从两端开始遍历，每次舍弃height[l],height[r]中短的那个
 * happygirlzt
 * 2018/7/24
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int n = height.length;
		int left = 0, right = n - 1;
		int max = 0;
		
		while(left < right) {
			int candidate = (height[left] < height[right] ? height[left] : height[right])
					* (right - left);
			max = (max > candidate) ? max : candidate;
			
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		
		return max;
	}

	// Updated on 9 Feb 2019
	public int maxArea1(int[] height) {
        int lo = 0, hi = height.length - 1;
        int max = 0;
        int leftMax = height[0], rightMax = height[hi];
        while (lo < hi) {
            max = Math.max(max, Math.min(rightMax, leftMax) * (hi - lo));
            if (height[lo] < height[hi]) {
                lo++;
                leftMax = Math.max(leftMax, height[lo]);
            } else if (height[hi] < height[lo]) {
                hi--;
                rightMax = Math.max(rightMax, height[hi]);
            } else {
                lo++;
                hi--;
                leftMax = Math.max(leftMax, height[lo]);
                rightMax = Math.max(rightMax, height[hi]);
            }
        }
        
        return max;
    }
}
