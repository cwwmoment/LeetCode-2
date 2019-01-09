/**
 * Created on 9 Jan 2019 by happygirlzt
 *
 * LeetCode #433. Minimum Genetic Mutation
 *
 */

public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;

        Deque<String> q = new ArrayDeque<>();
        int level = 0;
        Set<String> bankSet = new HashSet<>();
        for (String s: bank) {
            bankSet.add(s);
        }

        Set<String> visited = new HashSet<>();

        q.offer(start);
        visited.add(start);

        char[] cands = {'A', 'C', 'G', 'T'};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(end)) return level;

                char[] curArray = cur.toCharArray();
                for (int j = 0; j < curArray.length; j++) {
                    char prev = curArray[j];
                    for (char c: cands) {
                        curArray[j] = c;
                        String next = new String(curArray);
                        if (visited.add(next) && bankSet.contains(next)) {
                            q.offer(next);
                        }
                    }

                    curArray[j] = prev;
                }
            }

            level++;
        }

        return -1;
    }
}
