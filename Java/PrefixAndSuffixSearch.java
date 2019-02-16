/**
 * Created on 16 Feb 2019 by happygirlzt
 * 
 * LeetCode #745. Prefix and Suffix Search
 * 
 */

class WordFilter {

    class TrieNode {
        TrieNode[] children;
        int weight;
        public TrieNode() {
            children = new TrieNode[27];
            weight = 0;
        }
    }
    TrieNode root;
    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int weight = 0; weight < words.length; weight++) {
            String word = words[weight] + "{";
            for (int i = 0; i < word.length(); i++) {
                TrieNode cur = root;
                cur.weight = weight;
                for (int j = i; j < 2 * word.length() - 1; j++) {
                    int k = word.charAt(j % word.length()) - 'a';
                    if (cur.children[k] == null) {
                        cur.children[k] = new TrieNode();
                    }
                    
                    cur = cur.children[k];
                    cur.weight = weight;
                }   
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        TrieNode cur = root;
        for (char letter: (suffix + '{' + prefix).toCharArray()) {
            if (cur.children[letter - 'a'] == null) return -1;
            cur = cur.children[letter - 'a'];
        }
        return cur.weight;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */