/**
 * Created on 26 Oct 2018 by happygirlzt
 *
 * LeetCode #138 - Copy List with Random Pointer
 *
 */

// 这题的意思是返回一个原来链表的复制

public class CopyListWithRandomPointer {
    // HashMap
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode node = head;

        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }

    // Solution 2
    public RandomListNode copyRandomList2(RandomListNode head) {
        RandomListNode res = new RandomListNode(0);
        RandomListNode p = res;
        RandomListNode curr = head;

        while (curr != null) {
            p.next = clone(curr);
            curr = curr.next;
            p = p.next;
        }

        return res.next;
    }

    public RandomListNode clone(RandomListNode node) {
        RandomListNode dummy = new RandomListNode(node.label);
        if (node.random != null) {
            dummy.random = new RandomListNode(node.random.label);
        }

        return dummy;
    }

    // Updated on 30 Jan 2019
    // 注意比较两种不同的写法，返回值
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        helper(map, head);
        return map.get(head);
    }

    private void helper(Map<RandomListNode, RandomListNode> map, RandomListNode head) {
        if (head == null || map.containsKey(head)) return;

        map.put(head, new RandomListNode(head.label));

        helper(map, head.next);
        map.get(head).next = map.get(head.next);

        helper(map, head.random);
        map.get(head).random = map.get(head.random);
    }

    // 写法2
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        return  helper(map, head);
    }

    private RandomListNode helper(Map<RandomListNode, RandomListNode> map, RandomListNode head) {
        if (head == null) return null;
        if (map.containsKey(head)) return map.get(head);
        RandomListNode node = new RandomListNode(head.label);
        map.put(head, node);
        node.next = helper(map, head.next);
        node.random = helper(map, head.random);

        return node;
    }
}
