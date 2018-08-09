
public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		char[] tmp = s.toCharArray();
		
		for (char i : tmp) {
			System.out.println(i);
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		isPalindrome("A man, a plan, a canal: Panama");
	}
}
