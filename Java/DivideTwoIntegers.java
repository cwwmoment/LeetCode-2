/**
 * Created on 29 Sep 2018 by happygirlzt
 *
 * LeetCode #29. Divide Two Integers
 */

public class DivideTwoIntegers {
    public int divide(long dividend, long divisor) {
        int res = 0;
        if (dividend == 0) return res;

        int sign = 1;

        if (dividend > 0 && divisor < 0) {
            sign = -1;
            divisor = -divisor;
        }
        if (dividend < 0 && divisor > 0) {
            sign = -1;
            dividend = -dividend;
            dividend++;
        }

        if (dividend < 0 && divisor < 0) {
            dividend = -dividend;
            divisor = -divisor;
        }

        if (dividend < divisor) {
            return res;
        }


        res = 1;
        while (dividend - divisor > divisor) {
            res++;
            dividend -= divisor;
        }

        if (sign == -1) {
            if (-res < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return -res;
            }
        }

        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return res;
        }
    }

    // Updated on 5 Mar 2019
    public int divide1(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean isNeg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int res = 0;
        while (a >= b) {
            int shift = 1;
            while (a >= b << shift) {
                shift++;
            }

            a -= b << (shift - 1);
            res += 1 << (shift - 1);
        }

        return isNeg ? -res : res;
    }
}
