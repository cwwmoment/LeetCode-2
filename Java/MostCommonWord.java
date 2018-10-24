/**
 * Created on 24 Oct 2018 by happygirlzt
 *
 * LeetCode #819. Most Common Word
 *
 */

import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

public class MostCommonWord {
    // My solution
    public String mostCommonWord(String paragraph, String[] banned) {
        String trimed = paragraph.trim();
        trimed = trimed.toLowerCase();

        HashMap<String, Integer> map = new HashMap<>();
        char[] cs = trimed.toCharArray();

        HashSet<String> set = new HashSet<String>(Arrays.asList(banned));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= 'a' && cs[i] <= 'z' ) {
                sb.append(cs[i]);
            } else if (sb.length() != 0) {
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                sb.setLength(0);
            }
        }

        Map<String, Integer> sorted = map
            .entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(
                     toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                           LinkedHashMap::new));

        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            if (!set.contains(entry.getKey())) {
                return entry.getKey();
            }
        }

        return "";
    }

    // 别人的写法，思路虽然一样
    // 稍微有点优化，那就是先判断string是否在set中，如果不在在加进map里
    public String mostCommonWord1(String p, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();

        String[] words = p.replaceAll("\\W+", " ").toLowerCase().split("\\s+");

        for (String w : words) {
            if (!ban.contains(w)) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
        }

        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
