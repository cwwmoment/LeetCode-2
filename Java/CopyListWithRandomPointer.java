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

        // copy all the nodes
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
}
