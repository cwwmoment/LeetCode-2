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

    // Updated on 12 Feb 2019
    public String multiply1(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) return "";
        StringBuilder sb = new StringBuilder();

        int[] pos = new int[num1.length() + num2.length()];
        for (int j = num2.length() - 1; j >= 0; j--) {
            for (int i = num1.length() - 1; i >= 0; i--) {
                int mul = (int) (num1.charAt(i) - '0') * (int) (num2.charAt(j) - '0');
                mul += pos[i + j + 1];
                pos[i + j] += mul / 10;
                pos[i + j + 1] = mul % 10;
            }
        }

        for (int i : pos) {
            if (sb.length() != 0 || i != 0) {
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    // Updated on 9 Mar 2019
    public String multiply2(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int len1 = n1.length;
        int len2 = n2.length;
        int[] res = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                res[len1 + len2 - i - j - 2] += (n1[i] - '0') * (n2[j] - '0');
            }
        }

        for (int i = 0; i < len1 + len2 - 1; i++) {
            res[i + 1] += res[i] / 10;
            res[i] = res[i] % 10;
        }

        int index = len1 + len2 - 1;
        while (index >= 0) {
            if (res[index] == 0) {
                index--;
            } else break;
        }

        if (index < 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (index >= 0) {
            sb.append(res[index--]);
        }

        return sb.toString();
    }
}
