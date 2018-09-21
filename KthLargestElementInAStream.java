/**
 * Created on 21 Sep 2018 by happygirlzt
 *
 * LeetCode #703. Kth Largest Element in a Stream
 */

public class KthLargestElementInAStream {
    class KthLargest {
    // 我的超时的写法，又是有点接近了。。
    private PriorityQueue<Integer> pq1;
    private PriorityQueue<Integer> pq2;

    private static int key;
    public KthLargest(int k, int[] nums) {
        pq1 = new PriorityQueue<>(1000, Collections.reverseOrder());
        for (int i : nums) {
            pq1.offer(i);
        }

        pq2 = new PriorityQueue<>(1000);
        key = k;
    }

    public int add(int val) {
        pq1.offer(val);  // O(1)?

        for (int i = 0; i < key - 1; i++) {
            pq2.offer(pq1.poll());

            System.out.println(pq1.peek());
        }

        int tmp = pq1.peek();
        for (int i = 0; i < key - 1; i++) {
            pq1.offer(pq2.poll());
        }

        return tmp;
    }
    }
}

// Other's smart solution
// 用最小堆来存k个最大的数
class KthLargest1 {
    private PriorityQueue<Integer> q;
    private int size;

    public KthLargest1(int k, int[] nums) {
        size = k;
        q = new PriorityQueue<>(size);

        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        if (q.size() < size) {
            q.offer(val);
        } else if (q.peek() < val) {
            q.poll();
            q.offer(val);
        }

        return q.peek();
    }
}
