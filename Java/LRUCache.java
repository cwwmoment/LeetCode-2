/**
 * Created on 20 Sep 2018 by happygirlzt
 *
 * LeetCode #146. LRU Cache
 */
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 这题原来是要用双向链表。。。
 * java.util里的链表删除特定位置的节点是O(n)
 */
public class LRUCache1 {
    // My TLE trial...
    class LRUCache1 {
        private HashMap<Integer, Integer> map;
        private LinkedList<Integer> pri;
        private int cap;

        public LRUCache(int capacity) {
            map = new HashMap<>(capacity);
            pri = new LinkedList<>();
            cap = capacity;
        }

        public int get(int key) {
            // cache has key
            if (map.containsKey(key)) {
                for (int i = 0; i < pri.size(); i++) {
                    if (pri.get(i) == key) {
                        int tmp =  pri.remove(i);
                        pri.addFirst(tmp);
                        break;
                    }
                }

                return map.get(key);
            } else {
                return -1;
            }
        }

        // Can set, if key already exists!!!
        // Read question carefully!!!
        public void put(int key, int value) {
            // Exists, change the value
            if (map.containsKey(key)) {
                for (int i = 0; i < pri.size(); i++) {
                    if (pri.get(i) == key) {
                        pri.remove(i);
                        break;
                    }
                }
                map.remove(key);
                pri.addFirst(key);
                map.put(key, value);
            } else {
                // The key does not exist
                if (map.size() < cap) {
                    pri.addFirst(key);
                    map.put(key, value);
                } else {
                    // Capacity exceeds
                    // Is remove() not get()
                    int vic = pri.remove(pri.size() - 1);
                    map.remove(vic);
                    pri.addFirst(key);
                    map.put(key, value);
                }
            }
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}

// Modified on 23 Oct 2018
// use dlinkedlist

class LRUCache {
    class DListNode {
        DListNode pre;
        DListNode next;
        int key;
        int val;

        public DListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }

    private int capacity;
    HashMap<Integer, DListNode> map = new HashMap<>();
    private DListNode head = new DListNode(-1, -1);
    private DListNode tail = new DListNode(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.pre = head;
        head.next = tail;
    }

    public int get(int key) {
        // 不包含
        if (!map.containsKey(key)) {
            return -1;
        }

        DListNode node = map.get(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;

        moveToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).val = val;
            return;
        }

        DListNode node = new DListNode(key, value);
        if (map.size() == capacity) {
            DListNode delNode = head.next;
            int lru = delNode.key;
            map.remove(lru);
            delNode.pre.next = delNode.next;
            delNode.next.pre = delNode.pre;
        }

        map.put(key, node);
        moveToTail(node);
    }

    private void moveToTail(DListNode node) {
        node.pre = tail.pre;
        tail.pre.next = node;
        node.next = tail;
        tail.pre = node;
    }
}
