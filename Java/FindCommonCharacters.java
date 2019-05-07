/**
 * Created on 7 May 2019 by happygirlzt
 *
 * LeetCode #1002. Find Common Characters
 *
 */

class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int n = A.length;
        Map<Character, Integer>[] map = new HashMap[n];
        // System.out.println(map[0]);
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
            for (char c : A[i].toCharArray()) {
                map[i].put(c, map[i].getOrDefault(c, 0) + 1);
            }
        }

        for (char c : map[0].keySet()) {
            int min = map[0].get(c);
            for (int i = 1; i < n; i++) {
                if (map[i].getOrDefault(c, 0) < min) {
                    min = map[i].getOrDefault(c, 0);
                }
            }

            if (min > 0) {
                for (int i = 0; i < min; i++) {
                    res.add(Character.toString(c));
                }
            }
        }

        return res;
    }
}
