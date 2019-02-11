/**
 * Created on 5 Dec 2018 by happygirlzt
 *
 * LeetCode #849. Maximize Distance to Closest Person
 *
 */

public class MaximizeDistanceToClosestPerson {
    // Two pointers
    public int maxDistToClosest(int[] s) {
        int len = s.length;
        int left = -1;
        int res = 0;

        for (int i = 0; i < len; i++) {
            if (s[i] == 0) continue;

            if (left == -1) {
                res = Math.max(res, i);
            } else {
                res = Math.max(res, (i - left) / 2);
            }

            left = i;
        }

        if (s[len - 1] == 0) {
            res = Math.max(res, len - 1 - left);
        }

        return res;
    }

    // naive solution
    public int maxDistToClosest1(int[] s) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 1) {
                list.add(i);
            }
        }

        int res = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            res = Math.max(res, (list.get(i + 1) - list.get(i)) / 2);
        }

        int size = list.size();
        if (s[s.length - 1] == 0) {
            res = Math.max(res, s.length - 1 - list.get(size - 1));
        }

        if (s[0] == 0) {
            res = Math.max(res, list.get(0) - 0);
        }

        return res;
    }
}
