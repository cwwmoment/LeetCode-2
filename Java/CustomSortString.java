/**
 * Created on 5 Feb 2019 by happygirlzt
 *
 * LeetCode #791. Custom Sort String
 *
 */

class Solution {
    public String customSortString(String S, String T) {
        int[] map = new int[26];
        for (char c : T.toCharArray()) {
            map[(int) (c - 'a')]++;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            for (int j = 0; j < map[(int) (c - 'a')]; j++) {
                sb.append(c);
            }
            map[(int) (c - 'a')] = 0;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < map[i]; j++) {
                sb.append((char) (i + 'a'));
            }
        }

        return sb.toString();
    }
}
