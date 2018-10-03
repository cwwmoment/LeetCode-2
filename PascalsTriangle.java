/**
 * Created on 24 Sep 2018 by happygirlzt
 *
 * Modified on 3 Oct 2018
 *
 * LeetCode #118. Pascal's Triangle
 */

// 今天很快就做出来了，几分钟，上次想了很久没做出来。。上次是智障吗
public class PascalsTriangle {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j >= 0; j--) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else if (i > 1) {
                    list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(list);
        }

        return res;
    }
}
