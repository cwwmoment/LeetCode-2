/**
 * Created on 24 Dec 2018 by happygirlzt
 *
 * LeetCode #246. Strobogrammatic Number
 *
 */

class Solution {
    public boolean isStrobogrammatic(String num) {
        Set<String> set = new HashSet<>(Arrays.asList("0", "1", "8", "11", "00", "69", "96", "88"));
        int i = 0, j = num.length() - 1;
        while (i <= j) {
            if (!set.contains(num.charAt(i) + "" + num.charAt(j)))                     return false;
            i++; j--;
        }

        return true;
    }
}
