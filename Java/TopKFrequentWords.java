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


        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            pq.offer(entry);
        }

        while (res.size() < k) {
            res.add(pq.poll().getKey());
        }

        return res;
    }

    // Updated on 20 Dec 2018, Trie
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private void addWord(TrieNode root, String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }

        cur.word = word;
        cur.isWord = true;
    }

    private void getWords(TrieNode root, List<String> res, int k) {
        if (root == null) return;
        if (root.isWord) res.add(root.word);
        if (res.size() == k) return;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                getWords(root.children[i], res, k);
            }
        }
    }

    public List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        TrieNode[] count = new TrieNode[words.length + 1];
        for (String word: map.keySet()) {
            int freq = map.get(word);
            if (count[freq] == null) {
                count[freq] = new TrieNode();
            }

            addWord(count[freq], word);
        }

        // get k frequent words
        LinkedList<String> res = new LinkedList<>();
        for (int i = count.length - 1; i >= 1; i--) {
            if (count[i] == null) continue;
            getWords(count[i], res, k);
        }

        return res;
    }
}
