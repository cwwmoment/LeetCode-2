/**
 * LeetCode # 212. Word Search II
 *
 * Created by happygirlzt on 31 Aug 2018 at 9:26:46 PM
 *
 */
import java.util.List;
import java.util.ArrayList;

public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {
            res.add(p.word);
            p.word = null;
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    // 把words里的单词建一个前缀树
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    // Updated on 1 Mar 2019 by happygirlzt
    class TrieNode {
        TrieNode[] children;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }

    public List<String> findWords1(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0) return res;
        TrieNode root = new TrieNode();
        buildTrie(words, root);

        TrieNode cur = root;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (cur.children[c - 'a'] != null) {
                    dfs(board, res, i, j, cur);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] board, List<String> res, int i, int j, TrieNode cur) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) return;

        char c = board[i][j];

        if (c == '#' || cur.children[c - 'a'] == null)
            return;

        cur = cur.children[c - 'a'];

        if (cur.word != null) {   // found one
            res.add(cur.word);
            cur.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        dfs(board, res, i - 1, j ,cur);
        dfs(board, res, i, j - 1, cur);
        dfs(board, res, i + 1, j, cur);
        dfs(board, res, i, j + 1, cur);
        board[i][j] = c;
    }

    private void buildTrie1(String[] words, TrieNode root) {
        for (String word : words) {
            TrieNode cur = root;

            for (char c : word.toCharArray()) {
                int index = (int) (c - 'a');
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }

                cur = cur.children[index];
            }
            cur.word = word;
        }
    }
}
