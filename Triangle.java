/**
 * Created on 4 Oct 2018 by happygirlzt
 *
 * LeetCode #120. Triangle
 */

public class Triangle {
    public int minimumTotal(List<List<Integer>> tri) {
        int len = tri.size();
        if (len == 0 || tri == null) return 0;

        int res = 0;
        int[] dp = new int[len + 1];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < tri.get(i).size(); j++)
        }
    }
}
