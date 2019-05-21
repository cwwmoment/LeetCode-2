/**
 * Created on 21 May 2019 by happygirlzt
 *
 * LeetCode #551. Student Attendance Record I
 *
 */

class Solution {
    public boolean checkRecord(String s) {
        int aCount = 0, lCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                if (aCount == 1) return false;
                aCount++;
                lCount = 0;
            } else if (c == 'L') {
                lCount++;
                if (lCount > 2) return false;
            } else {
                lCount = 0;
            }
        }

        return true;
    }
}
