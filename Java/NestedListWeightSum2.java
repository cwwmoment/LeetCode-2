/**
 * Created on 19 Nov 2018 by happygirlzt
 *
 * LeetCode #364. Nested List Weight Sum II
 *
 */

public class NestedListWeightSum2 {
    // My solution
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = helper(nestedList);

        return dfs(nestedList, depth);
    }

    // The main problem here is to find the depth correctly
    public int helper(List<NestedInteger> list) {
        int res = 1;

        for (NestedInteger i : list) {
            if (!i.isInteger()) {
                res = Math.max(res, helper(i.getList()) + 1);
            } else {
                res = Math.max(res, 1);
            }
        }

        return res;
    }

    public int dfs(List<NestedInteger> list, int d) {
        int res = 0;

        for (NestedInteger i : list) {
            if (i.isInteger()) {
                res += i.getInteger() * d;
            } else {
                res += dfs(i.getList(), d - 1);
            }
        }

        return res;
    }

    // Other's solution
    public int depthSumInverse1(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        Queue<NestedInteger> q = new LinkedList<>();
        int pre = 0;
        int total = 0;
        for (NestedInteger i : nestedList) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            int size = q.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                NestedInteger cur = q.poll();
                if (cur.isInteger()) levelSum += cur.getInteger();
                List<NestedInteger> nextList = cur.getList();

                if (nextList != null) {
                    for (NestedInteger next : nextList) {
                        q.offer(next);
                    }
                }
            }

            pre += levelSum;
            total += pre;
        }

        return total;
    }

    // Updated on 24 Feb 2019
    public int depthSumInverse2(List<NestedInteger> nestedList) {
        int depth = getDepth(nestedList);
        return helper(nestedList, depth);
    }
    
    private int getDepth(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int res = 1;
        for (NestedInteger e : nestedList) {
            if (e.isInteger()) {
                continue;
            } else {
                res = Math.max(res, getDepth(e.getList()) + 1);
            }
        }
        
        return res;
    }
    
    private int helper(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger e : nestedList) {
            if (e.isInteger()) {
                sum += e.getInteger() * depth;
            } else {
                sum += helper(e.getList(), depth - 1);
            }
        }
        
        return sum;
    }
}
