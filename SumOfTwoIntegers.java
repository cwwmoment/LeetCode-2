/*
 * LeetCode # 371. Sum of Two Integers
 * happygirlzt
 * Created on 28/07/2018
 */

public class SumOfTwoIntegers {
	public static int getSum(int a, int b) {
		
		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		int x = 3;
		int y = 2;
		
		System.out.println(getSum(x, y));
	}
}
