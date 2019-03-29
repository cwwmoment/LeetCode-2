/**
 * Created on 29 Mar 2019 by happygirlzt
 *
 * LeetCode #676. Implement Magic Dictionary
 *
 */

class MagicDictionary {
    Set<String> set;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        set = new HashSet<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            set.add(word);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder(word);
            char original = sb.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                sb.setCharAt(i, c);
                if (c != original && set.contains(sb.toString())) return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */

// Optimized
class MagicDictionary {
    Set<String> set;
    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        set = new HashSet<>();
        map = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            set.add(word);
            generateNeighbors(word);
        }
    }

    private void generateNeighbors(String word) {
        for (int i = 0; i < word.length(); i++) {
            StringBuilder tmp = new StringBuilder(word);
            tmp.setCharAt(i, '*');
            map.put(tmp.toString(), map.getOrDefault(tmp.toString(), 0) + 1);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            StringBuilder tmp = new StringBuilder(word);
            tmp.setCharAt(i, '*');
            int freq = map.getOrDefault(tmp.toString(), -1);
            if (set.contains(word) && freq > 1 || !set.contains(word) && freq > 0) return true;
        }

        return false;
    }
}

// Another solution
class MagicDictionary {
    Map<Integer, List<String>> map;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word :dict) {
            int len = word.length();
            map.putIfAbsent(len, new ArrayList<>());
            map.get(len).add(word);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        int len = word.length();
        if (!map.containsKey(len)) return false;
        for (String candidate: map.get(len)) {
            int diff = 0;
            for (int i = 0; i < len; i++) {
                if (candidate.charAt(i) != word.charAt(i)) diff++;
            }

            if (diff == 1) return true;
        }
        return false;
    }
}
