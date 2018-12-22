/**
 * Created on 22 Dec 2018 by happygirlzt
 *
 * LeetCode #320. Generalized Abbreviation
 *
 */

// backtracking
class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), word, 0, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder tmp, String word, int start, int count) {
        // base case
        if (start == word.length()) {
            if (count > 0) tmp.append(count);
            res.add(tmp.toString());
            return;
        } else {
            int len = tmp.length();
            // abbr
            helper(res, tmp, word, start + 1, count + 1);
            tmp.setLength(len);

            // keep the char
            if (count > 0) tmp.append(count);
            tmp.append(word.charAt(start));
            helper(res, tmp, word, start + 1, 0);
            tmp.setLength(len);
        }
    }
}
