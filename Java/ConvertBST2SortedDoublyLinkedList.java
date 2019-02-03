/**
 * Created on 28 Nov 2018 by happygirlzt
 *
 * LeetCode #426. Convert Binary Search Tree to Sorted Doubly Linked List
 *
 */

public class ConvertBST2SortedDoublyLinkedList {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        Node leftHead = treeToDoublyList(root.left);
        Node rightHead = treeToDoublyList(root.right);

        root.left = root;
        root.right = root;

        return merge(merge(leftHead, root), rightHead);
    }

    private Node merge(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node tail1 = head1.left;
        Node tail2 = head2.left;

        tail1.right = head2;
        head2.left = tail1;
        tail2.right = head1;
        head1.left = tail2;

        return head1;
    }

    // Updated on 31 Jan 2019
    Node pre = null;
    Node head = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        helper(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void helper(Node root) {
        if (root == null) return;
        helper(root.left);
        if (pre == null) {
            head = root;
        } else {
            root.left = pre;
            pre.right = root;
        }

        pre = root;
        helper(root.right);
    }

    // Updated on 2 Feb 2019: iteratively
    public Node treeToDoublyList3(Node root) {
        if (root == null) return null;
        Node prev = null;
        Node head = null;
        Deque<Node> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (head == null) {
                head = root;
            }

            if (prev != null) {
                root.left = prev;
                prev.right = root;
            }

            prev = root;
            root = root.right;
        }

        head.left = prev;
        prev.right = head;

        return head;
    }
}
