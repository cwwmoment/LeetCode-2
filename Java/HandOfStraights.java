/**
 * Created on 12 Jan 2019 by happygirlzt
 *
 * LeetCode #846. Hand of Straights
 *
 */

class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        // corner case
        if (hand.length % W != 0) return false;

        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i < hand.length; i++) {
            if (map.get(hand[i]) >= 1) {
                int tmp = hand[i];
                map.put(tmp, map.get(tmp) - 1);
                for (int j = 1; j < W; j++) {
                    if (!map.containsKey(tmp + j)) {
                        return false;
                    } else {
                        map.put(tmp + j, map.get(tmp + j) - 1);
                    }
                }
            }
        }

        return true;
    }

    // Other's fast solution
    public boolean isNStraightHand1(int[] hand, int W) {
        int n = hand.length;
        if (n < W || n % W != 0) return false;

        int[] map = new int[W];
        for (int i : hand) {
            map[i % W]++;
        }

        for (int i = 1; i < W; i++) {
            if (map[i] != map[i - 1]) return false;
        }

        return true;
    }
}
