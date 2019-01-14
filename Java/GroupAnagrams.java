/**
 * Created on 14 Jan 2019 by happygirlzt
 *
 * LeetCode #49. Group Anagrams
 *
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            String key = getKey(s);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList(map.values());
    }

    private String getKey(String s) {
        StringBuilder res = new StringBuilder();

        char[] cs = s.toCharArray();
        Arrays.sort(cs);

        for (int i = 0; i < s.length(); i++) {
            res.append(cs[i] - 'a');
            res.append(",");
        }

        return res.toString();
    }
}
