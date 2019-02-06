/**
 * Created on 6 Feb 2019 by happygirlzt
 *
 * LeetCode #211. Add and Search Word - Data structure design
 *
 */

class WordDictionary {

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                cur.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), root, 0);
    }

    private boolean match(char[] chs, TrieNode cur, int index) {
        if (index == chs.length) {
            return cur.isWord;
        } else {
            if (chs[index] != '.') {
                return cur.children[chs[index] - 'a'] != null && match(chs, cur.children[chs[index] - 'a'], index + 1);
            } else {
                for (int i = 0; i < cur.children.length; i++) {
                    if (cur.children[i] != null && match(chs, cur.children[i], index + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
