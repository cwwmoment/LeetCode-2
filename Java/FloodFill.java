/**
 * Created on 15 Dec 2018 by happygirlzt
 *
 * LeetCode #733. Flood Fill
 *
 */

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = image[0].length;
        int preColor = image[sr][sc];

        // The following line is important, or we will get
        // stackoverflow...
        if (preColor == newColor) return image;
        dfs(image, m, n, sr, sc, preColor, newColor);

        return image;
    }

    private void dfs(int[][] image, int m, int n, int sr, int sc, int preColor, int newColor) {
        if (sr > m - 1 || sr < 0 || sc > n - 1 || sc < 0 ||
            image[sr][sc] != preColor) return;
        image[sr][sc] = newColor;
        dfs(image, m, n, sr + 1, sc, preColor, newColor);
        dfs(image, m, n, sr - 1, sc, preColor, newColor);
        dfs(image, m, n, sr, sc + 1, preColor, newColor);
        dfs(image, m, n, sr, sc - 1, preColor, newColor);
    }
}
