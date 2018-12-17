/**
 * Created on 17 Dec 2018 by happygirlzt
 *
 * LeetCode #415. Add Strings
 *
 */

class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return num2;
        if (num2 == null || num2.length() == 0) return num1;

        StringBuilder sb = new StringBuilder();

        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = num1.charAt(i--) - '0' + num2.charAt(j--) - '0' + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }

        while (i >= 0) {
            int sum = num1.charAt(i--) - '0' + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }

        while (j >= 0) {
            int sum = num2.charAt(j--) - '0' + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }

        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
