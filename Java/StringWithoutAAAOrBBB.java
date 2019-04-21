/**
 * Created on 21 Apr 2019 by happygirlzt
 *
 * LeetCode #984. String Without AAA or BBB
 *
 */

class Solution {
    public String strWithout3a3b(int A, int B) {
        int a = A, b = B;
        char ca = 'a', cb = 'b';
        if (A < B) {
            a = B;
            b = A;
            ca = 'b';
            cb = 'a';
        }

        StringBuilder sb = new StringBuilder();
        while (a > 0) {
            sb.append(ca);
            a--;

            if (a > b) {
                sb.append(ca);
                a--;
            }

            if (b > 0) {
                sb.append(cb);
                b--;
            }
        }

        return sb.toString();
    }
}
