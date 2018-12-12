/**
 * Created on 12 Dec 2018 by happygirlzt
 *
 * LeetCode #504. Base 7
 *
 */

class Solution {
    public String convertToBase7(int num) {
        // corner case
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();

        boolean negative = false;
        if (num < 0) {
            negative = true;
            num = -num;
        }

        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }

        if (negative) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }
}
