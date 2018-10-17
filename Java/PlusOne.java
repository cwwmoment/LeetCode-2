import java.util.Arrays;

/*
 * LeetCode #66 Plus One
 * @author happygirlzt
 * Created on 28/07/2018
 */

public class PlusOne {

	// 这个方法不行。。
	public static int[] plusOne0(int[] digits) {
		int len = digits.length;
		int tmp = 0;

		for (int i = 0; i < len; i++) {
			tmp += digits[i] * (int) Math.pow(10.0, len - i - 1.0);
		}

		tmp += 1;
		// System.out.println(tmp);

		String s = Integer.toString(tmp);

		int[] res = new int[s.length()];

		for (int j = 0; j < res.length; j++) {
			// System.out.println(s.charAt(j));
			res[j] = Character.getNumericValue(s.charAt(j));
			// System.out.println(res[j]);
		}

		return digits;
	}

	public static int[] plusOne2(int[] digits) {
		int len = digits.length;
		int[] tmp = new int[len + 1];
		int[] one = new int[len];
		one[len - 1] = 1;

		for (int i = len - 1; i > 0; i--) {
			if (one[i] + digits[i] >= 10) {
				tmp[i + 1] = (one[i] + digits[i]) % 10;
				one[i - 1] += (one[i] + digits[i]) / 10;
			} else {
				tmp[i + 1] = one[i] + digits[i];
			}
		}

		if (one[0] + digits[0] >= 10) {
			tmp[0] = (one[0] + digits[0]) / 10;
			tmp[1] = (one[0] + digits[0]) % 10;
		} else {
			tmp[1] = one[0] + digits[0];
			tmp = Arrays.copyOfRange(tmp, 1, len + 1);
		}

		return tmp;
	}

	public static int[] plusOne(int[] digits) {
		int len = digits.length;

		for (int i = len - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}

			digits[i] = 0;
		}

		int[] tmp = new int[len + 1];
		tmp[0] = 1;
		return tmp;
	}

	// 22 Aug 2018
	public static int[] plusOne4(int[] digits) {
		int len = digits.length;
		int[] tmp = new int[len+1];
		System.arraycopy(digits, 0, tmp, 1, len);
		// Attention this = sign!
		for (int i = len - 1; i >= 0; i--) {
			tmp[i+1] = (digits[i] + 1) % 10;
			int carry = (digits[i] + 1) / 10;
			if (carry != 1) {
				break;
			} else {
				tmp[i] += carry;
			}
		}

		int[] res = new int[len];
		System.arraycopy(tmp, 1, res, 0, len);
		if (tmp[0] == 0) {
			return res;
		}
		return tmp;
	}

	public static void main(String[] args) {
		int[] a = {9, 9};

		int[] res = plusOne4(a);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
