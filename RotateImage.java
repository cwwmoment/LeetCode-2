/**
 * Created on 20 Sep 2018 by happygirlzt
 *
 * Updated on 29 Sep 2018
 *
 * LeetCode #48. Rotate Image
 */

public class RotateImage {
    public void rotate(int[][] m) {
        if (m.length == 0 || m[0].length == 0) return;

        int n = m.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {

                }
                m[i][j] = m[n - 1 - j][i];
            }
        }
    }
}
