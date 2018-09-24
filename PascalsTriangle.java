/**
 * Created on 24 Sep 2018 by happygirlzt
 *
 * LeetCode #118. Pascal's Triangle
 */

public class PascalsTriangle {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>(i + 1));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res.get(i).set(j, )
            }
        }
    }
}
