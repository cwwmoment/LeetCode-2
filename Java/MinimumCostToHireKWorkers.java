/**
 * Created on 22 Mar 2019 by happygirlzt
 *
 * LeetCode #857. Minimum Cost to Hire K Workers
 *
 */

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int N = quality.length;
        Worker[] workers = new Worker[N];
        for (int i = 0; i < N; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }

        Arrays.sort(workers);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        double cost = Double.MAX_VALUE;
        int totalQuality = 0;
        for (Worker worker: workers) {
            totalQuality += worker.getQuality();
            maxHeap.offer(worker.getQuality());

            if (maxHeap.size() > K) {
                totalQuality -= maxHeap.poll();
            }

            if (maxHeap.size() == K) {
                cost = Math.min(cost, worker.getRatio() * totalQuality);
            }
        }

        return cost;
    }
}

class Worker implements Comparable<Worker> {
    private int quality;
    private int wage;
    public Worker(int q, int w) {
        quality = q;
        wage = w;
    }

    public int getQuality() {
        return quality;
    }

    public double getRatio() {
        return (double) wage / quality;
    }

    public int compareTo(Worker otherWorker) {
        if (this.getRatio() > otherWorker.getRatio()) {
            return 1;
        } else if (this.getRatio() < otherWorker.getRatio()) {
            return -1;
        }
        return 0;
    }
}
