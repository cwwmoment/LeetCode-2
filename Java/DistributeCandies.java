/**
 * Created on 20 May 2019 by happygirlzt
 *
 * LeetCode #575. Distribute Candies
 *
 */

class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int c : candies) {
            set.add(c);
        }

        int n = candies.length;
        if (set.size() > n / 2) return n / 2;
        return set.size();
    }
}
