/**
 * Created on 24 Dec 2018 by happygirlzt
 *
 * LeetCode #728. Self Dividing Numbers
 *
 */

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfdividing(i)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean isSelfdividing(int n) {
        int original = n;

        while (n > 0) {
            // Never forget
            if (n % 10 == 0) return false;
            if ((original % (n % 10)) != 0) return false;
            n = n / 10;
        }

        return true;
    }
}
