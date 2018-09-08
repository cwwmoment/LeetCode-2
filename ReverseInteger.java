/**
 * LeetCode 7. Reverse Integer
 * 
 * Created by happygirlzt on 8 Sep 2018 at 11:46:00 PM
 *
 */
public class ReverseInteger {
	public int reverse(int x) {
		int signBit = 1;
		if (x < 0) {
			signBit = -1;
			x = -x;
		} else if (x > 0) {
			signBit = 1;
		} else {
			return 0;
		}

		StringBuilder sb = new StringBuilder();
		while (x / 10 != 0) {
			sb.append(x % 10);
			x = x / 10;
		}
		sb.append(x % 10);
		int res = Integer.parseInt(sb.toString());
		if (res == Integer.MAX_VALUE) {
			return 0;
		}
		return res * signBit;
	}
}
