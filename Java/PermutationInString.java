/**
 * Created on 17 Jan on 2019 by happygirlzt
 *
 * LeetCode #567. Permutation in String
 *
 */

public boolean checkInclusion(String s1, String s2) {
    int[] map = new int[128];
    for (int i = 0; i < s1.length(); i++) {
        map[s1.charAt(i)]--;
    }

    for (int lo = 0, hi = 0; hi < s2.length(); hi++) {
        if (++map[s2.charAt(hi)] > 0) {
            while (--map[s2.charAt(hi++)] != 0) {}
        } else if ((hi - lo + 1) == s1.length()) return true;
    }

    return s1.length() == 0;
}
