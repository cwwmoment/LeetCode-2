/**
 * Created on 10 Nov 2018 by happygirlzt
 *
 * LeetCode #67. Add Binary
 *
 */

public class AddBinary {
    // 我的非常慢的做法
    public String addBinary(String a, String b) {
        LinkedList<Integer> sum = new LinkedList<>();
        if (a.length() < b.length()) {
            String tmp = b;
            b = a;
            a = tmp;
        }

        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();

        helper(ac, bc, sum);

        String str = sum.stream()
            .map(String::valueOf)
            .collect(Collectors.joining());

        return str;
    }

    public void helper(char[] a, char[] b, LinkedList<Integer> sum) {
        int carry = 0;

        for (int i = b.length - 1, j = a.length - 1; i >= 0; i--, j--) {
            int s = a[j] - '0' + b[i] - '0' + carry;
            if (s == 0 ||s == 1) {
                carry = 0;
                sum.addFirst(s);
            } else {
                carry = 1;
                sum.addFirst(s - 2);
            }
        }

        for (int j = a.length - b.length - 1; j >= 0; j--) {
            int s = carry + a[j] - '0';
            if (s == 0 || s == 1) {
                carry = 0;
                sum.addFirst(s);
            } else {
                carry = 1;
                sum.addFirst(s - 2);
            }
        }
    }

    // Other's solution
    public String addBinary1(String a, String b) {
        char[] res = a.length() >= b.length() ? a.toCharArray() : b.toCharArray();
        char[] buf = a.length() >= b.length() ? b.toCharArray() : a.toCharArray();

        int carry = 0;
        int beg = buf.length - 1;

        for (int i = res.length - 1; i >= 0; i--) {
            int sum = (res[i] - '0') + (beg < 0 ? 0 : (buf[beg--] - '0')) + carry;
            res[i] = (char) (sum % 2 + '0');
            carry = sum / 2;
        }

        String r = new String(res);

        if (carry > 0) {
            r = "1" + r;
        }

        return r;
    }

    // Updated on 17 Dec 2018
    public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
