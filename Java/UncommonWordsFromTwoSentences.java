/**
 * Created on 5 Jan 2019 by happygirlzt
 *
 * LeetCode #884. Uncommon Words from Two Sentences
 *
 */

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        if ((A == null || A.length() == 0) && (B == null || B.length() == 0)) return new String[0];
        if (A == null || A.length() == 0 || B == null || B.length() == 0) return A.length() == 0 ? new String[]{B} : new String[]{A};

        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : (A + " " + B).split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res.add(entry.getKey());
            }
        }

        return res.toArray(new String[res.size()]);
    }
}
