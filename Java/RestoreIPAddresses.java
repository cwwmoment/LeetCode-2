/**
 * Created on 18 Dec 2018 by happygirlzt
 *
 * LeetCode #93. Restore IP Addresses
 *
 */

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, "", 0);

        return res;
    }

    private void helper(List<String> res, String s, int index, String ret, int count) {
        if (count > 4) return;
        if (count == 4 && index == s.length()) res.add(ret);

        for (int i = 1; i < 4; i++) {
            if (i + index > s.length()) break;
            String tmp = s.substring(index, index + i);
            // if ((tmp.startsWith("0") && tmp.length() > 1) || (i == 3 && Integer.parseInt(tmp) > 255)) continue;
            // 0.0.0.0
            if ((tmp.length() > 1 && tmp.startsWith("0")) || Integer.parseInt(tmp) > 255) continue;
            helper(res, s, index + i, ret + tmp + (count == 3 ? "" : "."), count + 1);
        }
    }
}
