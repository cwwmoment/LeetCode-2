/**
 * Created on 19 Sep 2018 by happygirlzt
 *
 * LeetCode #295. Find Median from Data Stream
 */

import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    class MedianFinder1 {

        // My TLE trial
        private PriorityQueue<Integer> pq;
        private LinkedList<Integer> list;
        private int size;

        /** initialize your data structure here. */
        public MedianFinder() {
            pq = new PriorityQueue<>();
            list = new LinkedList<>();
            size = 0;
        }

        public void addNum(int num) {
             pq.add(num);
             size++;
        }

        public double findMedian() {
            if (size % 2 == 0) { // even
                int start = size / 2 - 1;
                for (int i = 0; i < start; i++) {
                    list.add(pq.poll());
                }

                int left = pq.poll();
                int right = pq.poll();
                pq.offer(left);
                pq.offer(right);

                for (int j = 0; j < start; j++) {
                    pq.offer(list.pop());
                }

                return (double) (left + right) / 2;
            } else {  // odd
                int mid = size / 2;
                for (int i = 0; i < mid; i++) {
                    list.add(pq.poll());
                }

                int res = pq.poll();
                pq.offer(res);

                for (int j = 0; j < mid; j++) {
                    pq.offer(list.pop());
                }

                return (double) res;
            }
        }
    }


    class MedianFinder {
        // Other's concise solution
        private PriorityQueue<Integer> min;
        private PriorityQueue<Integer> max;

        /** initialize your data structure here. */
        public MedianFinder() {
            min = new PriorityQueue<>();
            max = new PriorityQueue<>(10, Collections.reverseOrder());
        }

        public void addNum(int num) {
            max.offer(num);
            min.offer(max.poll());

            if (max.size() < min.size()) {
                max.offer(min.poll());
            }
        }

        public double findMedian() {
            if (max.size() == min.size()) {
                return (double) (min.peek() + max.peek()) / 2.0;
            } else {
                return max.peek();
            }
        }
    }
    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */

     // Updated on 25 Feb 2019
     // Use balance()
     class MedianFinder2 {

        private PriorityQueue<Integer> minHeap;
        private PriorityQueue<Integer> maxHeap;
        
        private void balance() {
            int minSize = minHeap.size();
            int maxSize = maxHeap.size();
            if (Math.abs(minSize - maxSize) < 2) return;
            
            if (maxSize > minSize) {
                minHeap.offer(maxHeap.poll());
            } else {
                maxHeap.offer(minHeap.poll());
            }
        }
        
        /** initialize your data structure here. */
        public MedianFinder() {
            minHeap = new PriorityQueue<>((a, b) -> a - b);
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
        }
        
        public void addNum(int num) {
            if (minHeap.size() == 0 || num > minHeap.peek()) {
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }
            
            balance();
        }
        
        public double findMedian() {
            
            if (minHeap.size() == maxHeap.size())
                return (double) (minHeap.peek() + maxHeap.peek()) / 2;
            
            if (minHeap.size() > maxHeap.size()) {
                return (double) minHeap.peek();
            }
            
            return (double) maxHeap.peek();
        }
    }
}
