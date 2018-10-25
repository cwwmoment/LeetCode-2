/**
 * Created on 25 Oct 2018 by happygirlzt
 *
 * LeetCode #692. Top K Frequent Words
 *
 */

// 这题主要考虑排序，比较的问题
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> res = new ArrayList<>();

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                                                                           (a,b) -> a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue()-a.getValue());

        // PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
        //         @Override
        //         public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
        //             if(entry1.getValue() == entry2.getValue()) {
        //                 return entry2.getKey().compareTo(entry1.getKey());
        //             }
        //             return entry1.getValue() - entry2.getValue();
        //         }
        //     });
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            pq.offer(entry);
        }

        while (res.size() < k) {
            res.add(pq.poll().getKey());
        }

        return res;
    }
}
