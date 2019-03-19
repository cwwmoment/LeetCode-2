/**
 * Created on 19 Mar 2019 by happygirlzt
 *
 * LeetCode #616. Add Bold Tag in String
 *
 */

class Solution {
    public String addBoldTag(String s, String[] dict) {
        if (s == null || s.length() == 0) return "";
        boolean[] dp = new boolean[s.length()];
        int index = 0;
        for (String word : dict) {
            index = s.indexOf(word, index);
            if (index > -1) {
                while (index != -1) {
                    int j = index;
                    for (; j < index + word.length(); j++) {
                        dp[j] = true;
                    }

                    index = s.indexOf(word, index + 1);
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();) {
            if (dp[i]) {
                sb.append("<b>");
                while (i < s.length() && dp[i]) {
                    sb.append(s.charAt(i++));
                }
                sb.append("</b>");
            } else {
                sb.append(s.charAt(i++));
            }
        }

        return sb.toString();
    }
}
