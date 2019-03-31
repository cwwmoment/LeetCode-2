/**
 * Created on 31 Mar 2019 by happygirlzt
 *
 * LeetCode #758. Bold Words in String
 *
 */

class Solution {
    public String boldWords(String[] words, String S) {
        int n = S.length();
        boolean[] bold = new boolean[n];
        int startIndex = 0;

        loop:
        for (String s : words) {
            startIndex = 0;

            while (true) {
                int index = S.indexOf(s, startIndex);
                if (index > -1) {
                    Arrays.fill(bold, index, index + s.length(), true);
                    startIndex = index + 1;
                } else {
                    continue loop;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!bold[i]) {
                sb.append(S.charAt(i));
            } else {
                int left = i;
                int right = i;
                while (i + 1 < n && bold[i + 1]) {
                    right = ++i;
                }

                sb.append("<b>");
                sb.append(S.substring(left, right + 1));
                sb.append("</b>");
            }
        }

        return sb.toString();
    }
}
