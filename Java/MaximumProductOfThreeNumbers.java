/**
 * Created on 23 Dec 2018 by happygirlzt
 *
 * LeetCode #628. Maximum Product of Three Numbers
 *
 */

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        int can1 = nums[0] * nums[1] * nums[len - 1];
        int can2 = nums[len - 1] * nums[len - 2] * nums[len - 3];

        return Math.max(can1, can2);
    }

    // Heap
    public int maximumProduct1(int[] nums) {
        PriorityQueue<Integer> posHeap = new PriorityQueue<>();
        PriorityQueue<Integer> negHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : nums) {
            posHeap.offer(i);
            negHeap.offer(i);
            if (posHeap.size() > 3) posHeap.poll();
            if (negHeap.size() > 2) negHeap.poll();
        }
        int max = 1;
        int can1 = 1;
        while (posHeap.size() > 0) {
            max = posHeap.peek();
            can1 *= posHeap.poll();
        }

        while (negHeap.size() > 0) {
            max *= negHeap.poll();
        }

        return Math.max(can1, max);
    }
}
