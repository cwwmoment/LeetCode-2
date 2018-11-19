/**
 * Created on 19 Nov 2018 by happygirlzt
 *
 * LeetCode #339. Nested List Weight Sum
 *
 */

public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    public int helper(List<NestedInteger> list, int d) {
        int res = 0;
        for (NestedInteger i : list) {
            if (i.isInteger()) {
                res += i.getInteger() * d;
            } else {
                res += helper(i.getList(), d + 1);
            }
        }

        return res;
    }
}
