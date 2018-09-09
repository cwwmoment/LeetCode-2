/**
 * LeetCode 7. Reverse Integer
 * 
 * Created by happygirlzt on 8 Sep 2018 at 11:46:00 PM
 *
 */
public class ReverseInteger {
	public int reverse(int x) {
		long res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			x = x / 10;
			if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
				return 0;
			}
		}
		
		return (int)res;
	}
	
	// Runtime Error
	public int reverse1(int x) {
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
        long res = Integer.parseInt(sb.toString());
        if ((int)res*signBit > Integer.MAX_VALUE || (int)res*signBit < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)res*signBit;
	}
}
