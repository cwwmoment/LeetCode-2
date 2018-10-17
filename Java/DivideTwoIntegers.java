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
}
