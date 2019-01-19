/**
 * Created on 19 Jan 2019 by happygirlzt
 *
 * LeetCode #382. Linked List Random Node
 *
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    private List<ListNode> list;
    private Random random;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        list = new ArrayList<>();
        random = new Random();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int res = random.nextInt(list.size());
        return list.get(res).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
