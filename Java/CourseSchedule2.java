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

        int[] indegree = new int[n];
        for (int i = 0; i < pr.length; i++) {
            indegree[pr[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                res[index++] = i;
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int course = q.poll();
            for (int i = 0; i < pr.length; i++) {
                if (pr[i][1] == course) {
                    indegree[pr[i][0]]--;
                    if (indegree[pr[i][0]] == 0) {
                        res[index++] = pr[i][0];
                        q.offer(pr[i][0]);
                    }
                }
            }
        }

        return index == n ? res : new int[0];
    }

    // Updated on 24 Jan 2019
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];

        // 1, 0 : 0 -> 1
        for (int[] relation : prerequisites) {
            indegree[relation[0]]++;
            map.putIfAbsent(relation[1], new ArrayList<>());
            map.get(relation[1]).add(relation[0]);
        }

        int[] res = new int[numCourses];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                res[count++] = i;
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int preCourse = q.poll();
            List<Integer> nextCourses = map.get(preCourse);
            if (nextCourses == null) continue;
            for (int course: nextCourses) {
                if (--indegree[course] == 0) {
                    res[count++] = course;
                    q.offer(course);
                }
            }
        }

        if (count != numCourses) return new int[0];
        return res;
    }
}
