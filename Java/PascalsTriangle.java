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

    // Updated on 19 Feb 2019
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        res.add(new ArrayList(Arrays.asList(1)));
        // if (numRows == 1) return res;
        // res.add(new ArrayList(Arrays.asList(1, 1)));
        
        for (int i = 2; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 1; j < i; j++) {
                tmp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            tmp.add(1);
            res.add(tmp);
        }
        
        return res;
    }
}
