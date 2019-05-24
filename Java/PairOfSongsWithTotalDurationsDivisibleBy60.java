/**
 * Created on 24 May 2019 by happygirlzt
 *
 * LeetCode #1010. Pairs of Songs With Total Durations Divisible by 60
 *
 */

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : time) {
            int d = (60 - t % 60) % 60;

            if (map.containsKey(d)) {
                count += map.get(d);
            }

            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);

        }

        return count;
    }
}
