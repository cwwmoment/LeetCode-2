/**
 * Created on 14 Jan 2019 by happygirlzt
 *
 * LeetCode #249. Group Shifted Strings
 *
 */

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strings) {
            String key = getKey(s);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList(map.values());
    }

    private String getKey(String s) {
        String key = "";
        for (int i = 1; i < s.length(); i++) {
            int offset = s.charAt(i) - s.charAt(i - 1);
            key += offset < 0 ? offset + 26 : offset;
            key += ",";
        }

        return key;
    }
}
