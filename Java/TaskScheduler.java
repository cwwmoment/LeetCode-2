/**
 * Created on 12 Nov 2018 by happygirlzt
 *
 * LeetCode #621. Task Scheduler
 *
 */

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        for (char t : tasks) {
            c[t - 'A']++;
        }

        Arrays.sort(c);
        int i = 25;
        while (i > 0 && c[i] == c[25]) i--;

        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }

    // Updated on 2 Feb 2019
    public int leastInterval1(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(map.values());

        int count = 0;
        while (maxHeap.size() > 0) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (maxHeap.size() > 0) {
                    tmp.add(maxHeap.poll());
                }
            }

            for (int i : tmp) {
                if (--i > 0) {
                    maxHeap.offer(i);
                }
            }

            count += maxHeap.size() > 0 ? n + 1 : tmp.size();
        }

        return count;
    }

    // O(N), O(1)
    public int leastInterval2(char[] tasks, int n) {
        int[] map = new int[26];
        for (int i : tasks) {
            map[i - 'A']++;
        }

        int maxFreq = 0;
        int num = 0;
        for (int i : map) {
            if (i > maxFreq) {
                maxFreq = i;
                num = 1;
            } else if (i == maxFreq) {
                num++;
            }
        }

        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + num);
    }
}
