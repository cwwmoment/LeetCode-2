
public class RomanToInteger {
	public static int romanToInt(String s) {
		
		if (s == null || s.length() < 1) return -1;

		int res = 0;
		int[] nums = new int[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'I') {
				nums[i] = 1;
			} else if (s.charAt(i) == 'V') {
				nums[i] = 5;
			} else if (s.charAt(i) == 'X') {
				nums[i] = 10;
			} else if (s.charAt(i) == 'L') {
				nums[i] = 50;
			} else if (s.charAt(i) == 'C') {
				nums[i] = 100;
			} else if (s.charAt(i) == 'D') {
				nums[i] = 500;
			} else if (s.charAt(i) == 'M') {
				nums[i] = 1000;
			}
		}

		for (int j = 0; j < nums.length - 1; j++) {
			if (nums[j] < nums[j+1]) {
				res = res - nums[j];
			} else {
				res = res + nums[j];
			}
		}
		
		return res + nums[nums.length - 1];
	}
	
	public static void main(String[] args) {
		String s = "IV";
		System.out.println(romanToInt(s));
	}
}
