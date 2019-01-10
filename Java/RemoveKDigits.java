/**
 * Created on 10 Jan 2019 by happygirlzt
 *
 * LeetCode #402. Remove K Digits
 *
 */

class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num.length(); i++) {
            char cur = num.charAt(i);
            while (sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) > cur) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            if (sb.length() == 0 && cur == '0') continue;

            sb.append(cur);
        }

        while (k > 0 && sb.length() >= k--) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
