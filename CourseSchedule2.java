/**
 * Created on 23 Sep 2018 by happygirlzt
 *
 * LeetCode #210. Course Schedule II
 */
public class CourseSchedule2 {
    public int[] findOrder(int n, int[][] pr) {
        int[] res = new int[n];

        // 注意这个corner case的写法，因为即使先修条件为空也是合理的
        if (n == 0) return res;

        int index = 0;
        // LinkedList<Integer> tmp = new LinkedList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < pr.length; i++) {
            indegree[pr[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                res[index++] = i;
                q.offer(i);
                //                tmp.add(i);
            }
        }

        while (!q.isEmpty()) {
            int course = q.poll();
            for (int i = 0; i < pr.length; i++) {
                if (pr[i][1] == course) {
                    indegree[pr[i][0]]--;
                    if (indegree[pr[i][0]] == 0) {
                        //                        tmp.add(pr[i][0]);
                        res[index++] = pr[i][0];
                        q.offer(pr[i][0]);
                    }
                }
            }
        }

        // if (tmp.size() == 0) return res;

        // for (int i = 0; i < n; i++) {
        //     res[i] = tmp.get(i);
        // }
        // return res;
        return index == n ? res : new int[0];
    }
}
