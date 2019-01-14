/**
 * Created on 14 Jan 2019 by happygirlzt
 *
 * LeetCode #386. Lexicographical Numbers
 *
 */

class Solution {
    // Solution 1:
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int cur = 1;

        for (int i = 1; i <= n; i++) {
            res.add(cur);

            if (cur * 10 <= n) {
                cur = cur * 10;
            } else if (cur % 10 != 9 && cur + 1 <= n) {
                cur++;
            } else {
                while ((cur / 10) % 10 == 9) {
                    cur /= 10;
                }
                cur = cur / 10 + 1;
            }
        }

        return res;
    }

    // Solution 2: dfs
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(res, i, n);
        }

        return res;
    }

    private void dfs(List<Integer> res, int i, int n) {
        // base case
        if (i > n) {
            return;
        } else {
            res.add(i);
            // recursive
            for (int j = 0; j < 10; j++) {
                if (i * 10 + j > n) return;
                dfs(res, i * 10 + j, n);
            }
        }
    }
}
