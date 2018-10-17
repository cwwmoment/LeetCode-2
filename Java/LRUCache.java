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

class DLinkedNode {
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;
}

/**
 * Always add the new node right after head;
 */
private void addNode(DLinkedNode node){
    node.pre = head;
    node.post = head.post;

    head.post.pre = node;
    head.post = node;
}

/**
 * Remove an existing node from the linked list.
 */
private void removeNode(DLinkedNode node) {
    DLinkedNode pre = node.pre;
    DLinkedNode post = node.post;

    pre.post = post;
    post.pre = pre;
}

/**
 * Move certain node in between to the head.
 */
private void moveToHead(DLinkedNode node){
    this.removeNode(node);
    this.addNode(node);
}

// pop the current tail.
private DLinkedNode popTail(){
    DLinkedNode res = tail.pre;
    this.removeNode(res);
    return res;
}

private Hashtable<Integer, DLinkedNode>
    cache = new Hashtable<Integer, DLinkedNode>();
private int count;
private int capacity;
private DLinkedNode head, tail;

public LRUCache(int capacity) {
    this.count = 0;
    this.capacity = capacity;

    head = new DLinkedNode();
    head.pre = null;

    tail = new DLinkedNode();
    tail.post = null;

    head.post = tail;
    tail.pre = head;
}

public int get(int key) {

    DLinkedNode node = cache.get(key);
    if(node == null){
        return -1; // should raise exception here.
    }

    // move the accessed node to the head;
    this.moveToHead(node);

    return node.value;
}


public void set(int key, int value) {
    DLinkedNode node = cache.get(key);

    if(node == null){

        DLinkedNode newNode = new DLinkedNode();
        newNode.key = key;
        newNode.value = value;

        this.cache.put(key, newNode);
        this.addNode(newNode);

        ++count;

        if(count > capacity){
            // pop the tail
            DLinkedNode tail = this.popTail();
            this.cache.remove(tail.key);
            --count;
        }
    }else{
        // update the value.
        node.value = value;
        this.moveToHead(node);
    }
}
