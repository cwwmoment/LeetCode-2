/**
 * LeetCode #208. Implement Trie (Prefix Tree) Created on 24/08/2018
 *
 * @author happygirlzt
 */
import java.util.HashMap;

public class Trie {
    class Node {
        HashMap<Character, Node> children;
        boolean isWord;

        Node(HashMap<Character, Node> child, boolean isWord) {
            children = child;
            this.isWord = isWord;
        }

        Node() {
            children = new HashMap<>();
            isWord = false;
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        HashMap<Character, Node> child = new HashMap<>();
        root = new Node(child, false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node dummy = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node node = dummy.children.get(ch);
            if (node == null) {
                node = new Node();
                dummy.children.put(ch, node);
            }

            dummy = node;
        }

        dummy.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node dummy = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node node = dummy.children.get(ch);
            if (node == null) {
                return false;
            }

            dummy = node;
        }

        return dummy.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node dummy = root;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            Node node = dummy.children.get(ch);
            if (node == null) {
                return false;
            }

            dummy = node;
        }

        return true;
    }
}

// Updated on 5 Feb 2019 using array
class Trie {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) return false;
            cur = cur.children[index];
        }

        return cur.isWord == true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (cur.children[index] == null) return false;
            cur = cur.children[index];
        }
        return true;
    }
}
