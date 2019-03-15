/**
 * Created on 3 Feb 2019 by happygirlzt
 *
 * LeetCode #973. K Closest Points to Origin
 *
 */

class Solution {
    // O(NlogK)
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
                return b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1];
            });

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[maxHeap.size()][2];
        int index = 0;
        while (maxHeap.size() > 0) {
            res[index++] = maxHeap.poll();
        }

        return res;
    }

    // Updated on 15 Mar 2019
    // quickSelect
    public int[][] kClosest1(int[][] points, int K) {
        quickSelect(points, K, 0, points.length - 1);
        int[][] res = new int[K][2];
        System.arraycopy(points, 0, res, 0, K);
        return res;
    }

    private void quickSelect(int[][] points, int K, int lo, int hi) {
        if (lo > hi) return;
        int pivotIndex = partition(points, lo, hi);
        if (pivotIndex == K) {
            return;
        }

        if (pivotIndex < K) {
            quickSelect(points, K, pivotIndex + 1, hi);
        } else {
            quickSelect(points, K, lo, pivotIndex - 1);
        }
    }
    private int partition(int[][] points, int lo, int hi) {
        Random random = new Random();
        int pivotIndex = random.nextInt(hi - lo + 1) + lo;

        //int pivotIndex = lo + (hi - lo) / 2;
        int pivotDist = dis(points[pivotIndex]);
        swap(points, pivotIndex, hi);

        int savedPos = hi;
        hi--;
        while (lo <= hi) {
            int loDist = dis(points[lo]);
            if (loDist > pivotDist) {
                swap(points, lo, hi--);
            } else {
                lo++;
            }
        }

        swap(points, lo, savedPos);
        return lo;
    }


    private int dis(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }
}
