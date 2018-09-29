/**
 * Created on 29 Sep 2018 by happygirlzt
 *
 * LeetCode #41. First Missing Positive
 */

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int res = 1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            if (left == res || right == res) {
                res++;
            } else if (left > res && right < res) {
                res = right + 1;

            } else if (right > res && left < res) {
                res = left + 1;
            }

            left++;
            right--;
        }

        return res;
    }

    // priority queue
    public int firstMissingPositive1(int[] nums) {
        if (nums.length == 0 || nums == null) return 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.offer(i);
        }

        int res = 1;
        while (!pq.isEmpty() && pq.peek() <= 0) {
            pq.poll();
        }

        if (!pq.isEmpty()) {
            if (pq.peek() > 1) {
                return res;
            } else {
                int tmp = pq.poll();
                while (!pq.isEmpty() && pq.peek() <= (tmp + 1)) {
                    tmp = pq.poll();
                }

                return ++tmp;
            }
        } else {
            return res;
        }
    }
}
