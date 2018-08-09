
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

	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 2, 2, 1 };
		System.out.println(topKFrequent(a, 1));
	}
}
