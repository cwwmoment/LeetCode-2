/**
 * Created on 27 Dec 2018 by happygirlzt
 *
 * LeetCode #406. Queue Reconstruction by Height
 *
 */

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p0, p1) -> {
                if (p0[0] == p1[0]) {
                    return p0[1] - p1[1];
                } else {
                    return p1[0] - p0[0];
                }
            });

        List<int[]> res = new ArrayList<>();
        for (int[] p: people) {
            res.add(p[1], p);
        }

        return res.toArray(new int[res.size()][]);
    }
}
