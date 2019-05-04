/**
 * Created on 4 May 2019 by happygirlzt
 *
 * LeetCode #405. Convert a Number to Hexadecimal
 *
 */

class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        String[] mapping = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

        while (num != 0) {
            // System.out.println(num % 16);
            sb.append(mapping[(num & 15)]);
            num = (num >>> 4);
        }

        return sb.reverse().toString();
    }
}
