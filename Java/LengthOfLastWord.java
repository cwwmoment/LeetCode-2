/**
 * LeetCode 58. Length of Last Word
 * 
 * Created on 2018-08-26
 * 
 * @author happygirlzt
 *
 */
public class LengthOfLastWord {
	// Use trim();
	public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) return 0;
		int count = 0;
		String ns = s.trim();
		for (int i = ns.length() - 1; i >= 0; i--) {
			if (ns.charAt(i) != ' ') {
				count++;
			} else {
				break;
			}
		}
		
		return count;
	}
	
	// Use flag
	public int lengthOfLastWord1(String s) {
		if (s == null || s.length() == 0) return 0;
		int len = s.length();
		int count = 0;
		boolean flag = false;
		for (int i = len - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				count++;
				flag = true;
			} else {
				if (flag) break;
			}
		}
		
		return count;
	}
}
