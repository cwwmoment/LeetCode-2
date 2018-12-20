/*
 * LeetCode # 347. Top K Frequent Elements
 * happygirlzt
 * Created on 30/07/2018
 */
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Collection;

public class TopKFrequentElements {
  public static List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> res = new ArrayList<>();

    Arrays.sort(nums);

    Set<Integer> set = new HashSet<>();

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (set.add(nums[i])) {
        map.put(nums[i], 1);
      } else {
        int tmp = map.get(nums[i]);
        map.remove(nums[i]);
        map.put(nums[i], tmp + 1);
      }
    }

    System.out.print(map);
    Collection<Integer> val = map.values();

    List<Integer> a = new ArrayList<>();

    for (Integer j : val) {
      a.add(j);
    }
    Collections.sort(a);
    Collections.reverse(a);

    System.out.print(a);

    Set<Integer> s = new HashSet<>();

    for (int m = 0; m < k; m++) {
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue().equals(a.get(m))) {
          if (s.add(entry.getKey())) {
            res.add(entry.getKey());
            System.out.println("Add a key" + entry.getKey());
          }
        }
      }
    }

    return res;
  }

    // Updated on 20 Dec 2018, bucket sort
    public List<Integer> topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int i : map.keySet()) {
            if (bucket[map.get(i)] == null) {
                bucket[map.get(i)] = new ArrayList<>();
            }
            bucket[map.get(i)].add(i);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 1 && res.size() < k; i--) {
            if (bucket[i] != null) {
                int size = k;
                for (int item: bucket[i]) {
                    res.add(item);
                    size--;
                    if (size == 0) break;
                }
            }
        }

        return res;
    }

    // Updated on 20 Dec 2018, heap
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((i1, i2) -> map.get(i1) - map.get(i2));
        for (int i : map.keySet()) {
            heap.offer(i);
            if (heap.size() > k) heap.poll();
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (heap.size() > 0) {
            res.add(heap.poll());
        }

        return res;
    }
}
