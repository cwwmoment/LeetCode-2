/**
 * Created on 9 Dec 2018 by happygirlzt
 * 
 * LeetCode #400. Nth Digit
 * 
 **/ 
 
 // 今天睡了一天。。。
 
class Solution {
    public int findNthDigit(int n) {
        int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}