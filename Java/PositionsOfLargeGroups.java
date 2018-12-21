/**
 * Created on 21 Dec 2018 by happygirlzt
 *
 * LeetCode #830. Positions of Large Groups
 *
 */

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (j == s.length() - 1 || s.charAt(i) != s.charAt(j + 1)) {
                if (j - i + 1 >= 3) {
                    res.add(Arrays.asList(new Integer[]{i, j}));
                }
                i = j + 1;
            }
        }

        return res;
    }
}
