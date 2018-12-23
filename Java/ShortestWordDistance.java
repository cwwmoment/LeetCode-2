/**
 * Created on 23 Dec 2018 by happygirlzt
 *
 * LeetCode #243. Shortest Word Distance
 *
 */

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                i1 = i;
            } else if (word2.equals(words[i])) {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1) {
                res = Math.min(res, Math.abs(i2 - i1));
            }
        }

        return res;
    }
}
