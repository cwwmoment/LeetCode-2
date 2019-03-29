/**
 * Created on 29 Mar 2019 by happygirlzt
 *
 * LeetCode #659. Split Array into Consecutive Subsequences
 *
 */

class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : nums) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }

        for (int i : nums) {
            if (map1.get(i) == 0) continue;

            if (map2.getOrDefault(i, 0) > 0) {
                map2.put(i, map2.get(i) - 1);
                map2.put(i + 1, map2.getOrDefault(i + 1, 0) + 1);
            } else if (map1.getOrDefault(i + 1, 0) > 0 &&
                       map1.getOrDefault(i + 2, 0) > 0) {
                map1.put(i + 2, map1.get(i + 2) - 1);
                map1.put(i + 1, map1.get(i + 1) - 1);
                map2.put(i + 3, map2.getOrDefault(i + 3, 0) + 1);
            } else return false;

            map1.put(i, map1.get(i) - 1);
        }

        return true;
    }
}
