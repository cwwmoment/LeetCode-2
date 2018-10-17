/**
 * Created on 3 Oct 2018 by happygirlzt
 *
 * LeetCode #119. Pascal's Triangle II
 */

public class PascalsTriangle2 {
    // pure recursion will Time Limit Exceeded
    // 10/34 test cases passed.
    public List<Integer> getRow(int r) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= r; i++) {
            if (i == 0 || i == r) {
                res.add(1);
            } else if (r > 1) {
                int left = getRow(r - 1).get(i - 1);
                int right = getRow(r - 1).get(i);
                res.add(left + right);
            }
        }

        return res;
    }

    public List<Integer> getRow1(int r) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= r; i++) {
            List<Integer> l = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    l.add(1);
                } else if (i > 1) {
                    l.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }

            list.add(l);
        }

        return list.get(r);
    }

    // Other's smart solution
    public List<Integer> getRow2(int r) {
        long k = 1;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= r; i++) {
            res.add((int)k);
            k = k * (r - i)/(i + 1);
        }

        return res;
    }
}
