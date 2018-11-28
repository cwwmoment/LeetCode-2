/**
 * Created on 28 Nov 2018 by happygirlzt
 *
 * LeetCode #43. Multiply Strings
 *
 */

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();

        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                res[i + j + 1] += (num1.charAt(i) - '0' ) * (num2.charAt(j) - '0');
            }
        }

        int carry = 0;

        for (int i = res.length - 1; i >= 0; i--) {
            int tmp = (res[i] + carry) % 10;
            carry = (res[i] + carry) / 10;
            res[i] = tmp;
        }

        StringBuilder sb = new StringBuilder();

        for (int num : res) {
            sb.append(num);
        }

        while (sb.length() != 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
