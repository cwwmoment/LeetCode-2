/**
 * Created on 6 Apr 2019 by happygirlzt
 *
 * LeetCode #245. Shortest Word Distance III
 *
 */

class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index = -1;
        int minDis = words.length;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) ||
                words[i].equals(word2)) {
                if (index == -1 || !word1.equals(word2) && words[i].equals(words[index])) {
                    index = i;
                } else {
                    minDis = Math.min(i - index, minDis);
                    index = i;
                }
            }
        }

        return minDis;
    }
}
