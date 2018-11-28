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
}
