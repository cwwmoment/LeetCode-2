/**
 * Created on 22 Jan 2019 by happygirlzt
 *
 * LeetCode #414. Third Maximum Number
 *
 */

class Solution {
    public int thirdMax(int[] nums) {
        Integer top = null;
        Integer sec = null;
        Integer thi = null;

        for (Integer i : nums) {
            if (i.equals(top) || i.equals(sec) || i.equals(thi)) continue;

            if (top == null || i > top) {
                thi = sec;
                sec = top;
                top = i;
            } else if (sec == null || i > sec) {
                thi = sec;
                sec = i;
            } else if (thi == null || i > thi) {
                thi = i;
            }
        }

        return thi == null ? top : thi;
    }
}
