/**
 * LeetCode # 96. Unique Binary Search Trees
 * 
 * Created on 2018-08-26
 * 
 * @author happygirlzt
 *
 */
public class UniqueBinarySearchTree {
	/**
	 * 一般要求最终的数量而不需要具体的列出来的，或者
	 * 返回boolean值，要想到动态规划。
	 * dp的四个关键点：
	 * state
	 * init 初始化
	 * 转移方程
	 * 返回值
	 * @param n
	 * @return dp[n]
	 */
	public int numTrees(int n) {
		if (n == 0 || n == 1) return n;
		
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		
		return dp[n];
	}
}
