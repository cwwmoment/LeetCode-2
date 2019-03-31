/**
 * Created on 31 Mar 2019 by happygirlzt
 *
 * LeetCode #916. Word Subsets
 *
 */

class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int n = B.length;
        int[] map = new int[26];
        for (String b : B) {
            int[] tmp = new int[26];
            getFrequency(b, tmp);
            for (int i = 0; i < 26; i++) {
                map[i] = Math.max(map[i], tmp[i]);
            }
        }

        List<String> res = new ArrayList<>();

        loop:
        for (String a : A) {
            int[] ma = new int[26];
            getFrequency(a, ma);
            for (int i = 0; i < 26; i++) {
                if (ma[i] < map[i]) {
                    continue loop;
                }
            }

            res.add(a);
        }

        return res;
    }

    private void getFrequency(String s, int[] map) {
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
    }
}
