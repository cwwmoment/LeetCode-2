/**
 * Created on 23 Sep 2018 by happygirlzt
 *
 * LeetCode #207. Course Schedule
 */

public class CourseSchedule {
    // BFS: Queue
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // corner case
        if (numCourses == 0 || prerequisites.length == 0) return true;

        // Use adjacent list to represent graph
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            // index 0 is prerequisites course, has a indegree
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            // enqueue indegree 0 index
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // courses that do not need prerequisites
        int canFinishCount = q.size();
        while (!q.isEmpty()) {
            int pre = q.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == pre) {
                    // delete the courses that outdegree is pre
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        canFinishCount++;
                        q.offer(prerequisites[i][0]);
                    }
                }
            }
        }

        return (canFinishCount == numCourses);
    }

    // DFS, 先用邻接表来表示图
    public boolean canFinish1(int n, int[][] pr) {
        if (n == 0 || pr.length == 0) return true;

        ArrayList[] G = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            G[i] = new ArrayList();
        }

        boolean[] visited = new boolean[n];
        boolean[] dp = new boolean[n];
        for (int i = 0; i < pr.length; i++) {
            G[pr[i][1]].add(pr[i][0]);
        }

        for (int i = 0; i < n; i++) {
            if (!dfs(G, visited, i, dp)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(ArrayList[] G, boolean[] visited, int course, boolean[] dp) {
        if (visited[course]) {
            return dp[course];
        } else {
            visited[course] = true;
        }

        for (int i = 0; i < G[course].size(); i++) {
            if (!dfs(G, visited, (int)G[course].get(i), dp)) {
                dp[course] = false;
                return false;
            }
        }

        dp[course] = true;
        return true;
    }
}
