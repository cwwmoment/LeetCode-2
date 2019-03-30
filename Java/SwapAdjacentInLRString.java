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

    // Updated on 30 Mar 2019
    // O(N)
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;
        // if (!start.replace("X", "").equals(end.replace("X", ""))) return false;

        int indexS = 0, indexE = 0;
        int len = start.length();
        while (indexS < len && indexE < len) {
            while (indexS < len && start.charAt(indexS) == 'X') {
                indexS++;
            }

            while (indexE < len && end.charAt(indexE) == 'X') {
                indexE++;
            }

            if ((indexE == len) ^ (indexS == len)) return false;
            if (indexE < len && indexS < len) {
                if (start.charAt(indexS) != end.charAt(indexE)) return false;
                if (start.charAt(indexS) == 'R' && indexS > indexE) return false;
                if (start.charAt(indexS) == 'L' && indexS < indexE) return false;
            }

            indexS++;
            indexE++;
        }
        return true;
    }
}
