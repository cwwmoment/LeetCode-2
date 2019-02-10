/**
 * Created on 10 Feb 2019 by happygirlzt
 *
 * LeetCode #893. Groups of Special-Equivalent Strings
 */

class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet<>();
        for (String s : A) {
            int[] odd = new int[26];
            int[] even = new int[26];
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 0) {
                    even[s.charAt(i) - 'a']++;
                } else {
                    odd[s.charAt(i) - 'a']++;
                }
            }
            seen.add(Arrays.toString(even) + Arrays.toString(odd));
        }
        return seen.size();
    }
}