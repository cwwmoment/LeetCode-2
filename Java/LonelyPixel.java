/**
 * Created on 25 Nov 2018 by happygirlzt
 *
 * LeetCode #531. Lonely Pixel I
 *
 */

public class LonelyPixel {
    // My solution
    public int findLonelyPixel(char[][] picture) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        if (picture == null || picture.length == 0) return 0;
        for (int i = 0; i < picture.length; i++) {
            int count = 0;
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    if (count == 0) {
                        count++;
                        if (set2.contains(j)) {
                            continue;
                        } else if (set1.contains(j)){
                            set2.add(j);
                            set1.remove(j);
                        } else {
                            set1.add(j);
                        }
                    } else {
                        set2.addAll(set1);
                        set1.clear();
                    }

                }
            }
        }

        return set1.size();
    }

    // Other's solution
    public int findLonelyPixel1(char[][] p) {
        if (p == null || p.length == 0) return 0;

        int m = p.length, n = p[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p[i][j] == 'B') {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
