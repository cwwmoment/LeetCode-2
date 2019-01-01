/**
 * Created on 1 Jan 2019 by happygirlzt
 *
 * LeetCode #777. Swap Adjacent in LR String
 *
 */

class Solution {
    public boolean canTransform(String start, String end) {
        char[] sc = start.toCharArray();
        char[] ec = end.toCharArray();

        int n = start.length();
        int i = 0, j = 0;

        while (i < n && j < n) {
            while (i < n && sc[i] == 'X') {
                i++;
            }

            while (j < n && ec[j] == 'X') {
                j++;
            }

            if (i == n && j == n) return true;
            if (i == n || j == n) return false;

            if (sc[i] != ec[j]) return false;

            if (sc[i] == 'L' && i < j) return false;
            if (ec[j] == 'R' && i > j) return false;

            i++;
            j++;
        }

        return true;
    }
}
