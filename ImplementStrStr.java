
public class ImplementStrStr {
	public static int strStr(String haystack, String needle) {
		if (needle == null || needle.length() == 0)
			return 0;
		if (haystack == null || haystack.length() == 0)
			return -1;

		int hayLen = haystack.length();
		int needLen = needle.length();

		for (int i = 0; i < needLen; i++) {
			for (int j = 0; j < hayLen - needLen; j++) {
				if (haystack[j] == needle[i]) {
					
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "ll";

		System.out.println(strStr(s1, s2));
	}
}
