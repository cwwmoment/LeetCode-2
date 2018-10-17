/*
 * LeetCode #771.Jewels and Stones
 * happygirlzt
 * Created on 14 July 2018
 * 
 */
import java.util.HashSet;
import java.util.Set;

class JewelsandStones {
	// Solution 1
    public static int numJewelsInStones(String J, String S) {
        int count = 0;

        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < J.length(); j++) {
                if (S.charAt(i) == J.charAt(j)) {
                    count++;
                }
            }
        }

        return count;
    }
    
    // Solution 2
    public static int numJewelsInStones1(String J, String S) {
        int count = 0;

        Set<Character> setj = new HashSet<>();

        for(char i : J.toCharArray()) {
            setj.add(i);
        }

        for (char j : S.toCharArray()) {
            if (setj.contains(j)) {
                count++;
            }
        }

        return count;
    }
    
    // Solution 3: regex
    public static int numJewelsInStones2(String J, String S) {
        return(S.replaceAll("[^" + J + "]", "").length());
    }
}