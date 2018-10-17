/**
 * Created on 13 Sep 2018 by happygirlzt
 *
 * LeetCode  #367. Valid Perfect Square
 */

public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        // If use int, then will overflow
        long left = 0, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (mid * mid == num || right * right == num || left * left == num) {
                return true;
            } else if (mid * mid < num) {
                left = mid + 1;
            } else if (mid * mid > num) {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int num = 808201;
        System.out.println(isPerfectSquare(num));
    }
}
