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

    /* Updated on 5 Feb 2019
     * Time complexity: O(N*K), N is the length of strs, K is the maximum length of the word
     * Space complexity: O(N*K)
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] mapping = new int[26];
            for (char c: s.toCharArray()) {
                mapping[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(mapping[i]).append("#");
            }
            map.putIfAbsent(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(s);
        }

        return new ArrayList(map.values());
    }
}
