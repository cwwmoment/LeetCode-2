/**
 * LeetCode #140. Word Break II
 *
 * @author happygirlzt
 *
 */

public class WordBreak2 {
    // Other's smart solution
    public List<String> wordBreak1(String s, List<String> wordDict) {
        Set<String> wordDicts = new HashSet<>(wordDict);
        return DFS(s, wordDicts, new HashMap<String, ArrayList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> wordDict, HashMap<String, ArrayList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        ArrayList<String> res = new ArrayList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
}
