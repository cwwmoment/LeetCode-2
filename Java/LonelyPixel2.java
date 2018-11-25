/**
 * Created on 25 Nov 2018 by happygirlzt
 *
 * LeetCode #533. Lonely Pixel2
 *
 */

public class LonelyPixel2 {
    public int findBlackPixel(char[][] p, int N) {
        if (p == null || p.length == 0) return 0;

        HashMap<String, Integer> map = new HashMap<>();
        int m = p.length, n = p[0].length;

        int[] colCount = new int[n];

        for (int i = 0; i < m; i++) {
            int rowCount = 0;
            for (int j = 0; j < n; j++) {
                if (p[i][j] == 'B') {
                    rowCount++;
                    colCount[j]++;
                }
            }

            if (rowCount == N) {
                String s = new String(p[i]);
                if (!map.containsKey(s)) {
                    map.put(s, 1);
                } else {
                    map.put(s, map.get(s) + 1);
                }

            }
        }

        int count = 0;

        for (String s : map.keySet()) {
            if (map.get(s) != N) continue;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'B' && colCount[i] == N) count += N;
            }
        }
        return count;
    }
}
