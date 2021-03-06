/**
 * Created on 20 Sep 2018 by happygirlzt
 *
 * Updated on 29 Sep 2018, 8 Oct 2018
 *
 * LeetCode #48. Rotate Image
 */

// 找规律题我一直不太擅长
public class RotateImage {
    public void rotate(int[][] m) {
        if (m.length == 0 || m[0].length == 0) return;

        int n = m.length;
        int tmp = 0;
f        for (int i = 0; i <= (n - 1) / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                tmp = m[i][j];
                m[i][j] = m[n - 1 - j][i];
                m[n - 1 - j][i] = m[n - 1 - i][n - 1 - j];
                m[n - 1 - i][n - 1 - j] = m[j][n - 1 - i];
                m[j][n - 1 - i] = tmp;
            }
        }
    }

    // Updated on 16 Feb 2019
    // Start from the outer layer and then to the inner layer
    public void rotate1(int[][] m) {
        if (m.length == 0 || m.length != m[0].length) return;
        int n = m.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = m[first][first + offset];
                m[first][first + offset] = m[last - offset][first];
                m[last - offset][first] = m[last][last - offset];
                m[last][last - offset] = m[first + offset][last];
                m[first + offset][last] = top;
            }
        }
    }
}
