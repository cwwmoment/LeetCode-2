/**
 * LeetCode #6. ZigZag Conversion
 * 
 * Created by happygirlzt on 12 Sep 2018
 */

import java.lang.StringBuilder;

public class ZigZagConversion {
	public static String convert(String s, int numRows) {
		if (numRows == 0 || numRows == 1 || s == null || s.length() == 0) return s;
		
		StringBuilder res = new StringBuilder(0);
		int len = s.length(), interval = (numRows << 1) - 2;
		char[] cs = s.toCharArray();
		
		// 先处理第一行
		for (int i = 0; i < len; i += interval) {
			res.append(cs[i]);
		}
		
		// 中间
		for (int i = 1; i < numRows - 1; i++) {
			int inter = (i << 1); // inter = i * 2
			for (int j = i; j < len; j += inter) {
				res.append(cs[j]);
				inter = interval - inter;
			}
		}
		
		// 最后一行
		for (int i = numRows - 1; i < len; i += interval) {
			res.append(cs[i]);
		}
		
		return res.toString();
	}
	
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 3;
		System.out.println(convert(s, numRows));
	}
}
