import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;

public class TopKFrequentWords {
	public static List<String> topKFrequent(String[] words, int k) {
		List<String> res = new ArrayList<>();

		Arrays.sort(words);

		for (String str : words) {
			System.out.println(str);
		}

		Set<String> set = new HashSet<>();

		Map<String, Integer> map = new HashMap<>();

		// Build the frequency dict
		for (String i : words) {
			if (set.add(i)) {
				map.put(i, 1);
			} else {
				int tmp = map.get(i);
				map.remove(i);
				map.put(i, tmp + 1);
			}
		}

		Collection<Integer> val = map.values();

		List<Integer> list = new ArrayList<>();

		for (Integer j : val) {
			list.add(j);
		}

		Collections.sort(list);
		Collections.reverse(list);

		Set<String> tmp = new HashSet<>();

		for (int m = 0; m < k; m++) {
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				if (entry.getValue().equals(list.get(m))) {
					if (tmp.add(entry.getKey())) {
						res.add(entry.getKey());
						continue;
					}
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		String[] s = { "i", "love", "leetcode", "i", "love", "coding" };
		System.out.println(topKFrequent(s, 2));
	}
}
