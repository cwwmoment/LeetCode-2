/**
 * Created on 19 Apr 2019 by happygirlzt
 *
 * LeetCode #821. Shortest Distance to a Character
 *
 */

class Solution {
    // O(NlogN)
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                set.add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            Integer prev = set.floor(i);
            Integer next = set.ceiling(i);
            if (prev == next) {
                res[i] = 0;
            } else if (prev == null) {
                res[i] = set.first() - i;
            } else if (next == null) {
                res[i] = i - set.last();
            } else {
                res[i] = Math.min(i - prev, next - i);
            }
        }

        return res;
    }

    // O(N)
    public int[] shortestToChar1(String S, char C) {
        int n = S.length();
        int[] res = new int[n];

        int prev = Integer.MIN_VALUE / 2;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C) {
                prev = i;
            }
            res[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = n - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                prev = i;
            }

            res[i] = Math.min(res[i], prev - i);
        }

        return res;
    }
}
