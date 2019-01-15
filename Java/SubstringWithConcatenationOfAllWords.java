/**
 * Created on 15 Jan 2019 by happygirlzt
 *
 * LeetCode #30. Substring with Concatenation of All Words
 *
 */

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        // corner case
        if (s == null || words.length == 0) return res;
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int n = words.length, m = words[0].length();
        // Pay attention to the = sign
        for (int i = 0; i <= s.length() - m * n; i++) {
            Map<String, Integer> copy = new HashMap(map);
            int j = i;
            int k = n;

            while (k > 0) {
                String str = s.substring(j, j + m);
                if (!copy.containsKey(str) || copy.get(str) < 1) {
                    break;
                }

                copy.put(str, copy.get(str) - 1);
                j += m;
                k--;
            }

            if (k == 0) res.add(i);
        }

        return res;
    }
}
