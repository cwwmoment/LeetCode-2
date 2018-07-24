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
}
