/**
 * Created on 20 Sep 2018 by happygirlzt
 *
 * LeetCode #146. LRU Cache
 */
import java.util.HashMap;
import java.util.LinkedList;

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

// Updated on 20 Jan 2019
class LRUCache {
    private final Map<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node n = cache.get(key);
            remove(n);
            setHead(n);
            return n.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node old = cache.get(key);
            old.val = value;
            remove(old);
            setHead(old);
        } else {
            Node n = new Node(key, value);
            int size = cache.size();
            if (size >= this.capacity) {
                cache.remove(tail.key);
                remove(tail);
                setHead(n);
            } else {
                setHead(n);
            }
            cache.put(key, n);
        }
    }

    private void setHead(Node n) {
        n.next = head;
        n.pre = null;
        if (head != null) {
            head.pre = n;
        }
        head = n;
        if (tail == null) {
            tail = head;
        }
    }

    private void remove(Node n) {
        Node pre = n.pre;
        Node next = n.next;
        if (pre != null) {
            pre.next = next;
        } else {
            head = next;
        }

        if (next != null) {
            next.pre = pre;
        } else {
            tail = pre;
        }
    }

    static class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }
}

// Updated on 13 Feb 2019
class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }
    
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity;
    private int size;
    
    public LRUCache(int capacity) {
        /*
        Pay attention to initialize and link the head and tail
        */
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addHead(node);
            return node.val;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            node.val = value;
            addHead(node);
        } else {
            Node node = new Node();
            node.key = key;
            node.val = value;
            addHead(node);
            if (size > capacity) removeTail();
        }
    }
    
    private void addHead(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        size++;
    }
    
    private void remove(Node node) {
        map.remove(node.key);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        size--;
    }
    
    private void removeTail() {
        Node node = tail.prev;
        remove(node);
    }
}