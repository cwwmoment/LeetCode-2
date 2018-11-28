/**
 * Created on 28 Nov 2018 by happygirlzt
 *
 * LeetCode #341. Flatten Nested List Iterator
 *
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Iterator<Integer> iter;
    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();
        if (nestedList != null) {
            flatten(nestedList, list);
        }

        iter = list.iterator();
    }

    private void flatten(List<NestedInteger> nestedList, List<Integer> list) {
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                list.add(n.getInteger());
            } else {
                flatten(n.getList(), list);
            }
        }
    }

    @Override
    public Integer next() {
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class NestedIterator implements Iterator<Integer> {
    Deque<Iterator<NestedInteger>> s;
    Iterator<NestedInteger> iter;
    NestedInteger cur;

    public NestedIterator(List<NestedInteger> nestedList) {
        iter = nestedList.iterator();
        s = new ArrayDeque<>();
        cur = null;
    }

    @Override
    public Integer next() {
        int res = cur.getInteger();
        cur = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        while (cur == null) {
            if (iter.hasNext()) {
                NestedInteger tmp = iter.next();
                if (tmp.isInteger()) {
                    cur = tmp;
                    return true;
                } else {
                    s.push(iter);
                    iter = tmp.getList().iterator();
                }
            } else if (!s.isEmpty()) {
                iter = s.pop();
            } else {
                return false;
            }
        }

        return false;
    }
}
