/**
 * Updated on 3 Mar 2019 by happygirlzt
 *
 * LeetCode #105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 */

public class ConstructBinaryTreePreorderInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || preorder == null) return null;
        if (inorder.length == 0 || inorder == null) return null;
        if (preorder.length != inorder.length) return null;

        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;

        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }

        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart - 1, inIndex + 1, inEnd, preorder, inorder);

        return root;
    }

    // Updated on 30 Jan 2019 by happygirlzt
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, inorderMap, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, Map<Integer, Integer> inorderMap, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = inorderMap.get(preorder[preStart]);
        root.left = helper(preorder, preStart + 1, preStart + index - inStart, inorderMap, inStart, index - 1);
        root.right = helper(preorder, preStart + index - inStart + 1, preEnd, inorderMap, index + 1, inEnd);
        return root;
    }

    // Updated on 3 Mar 2019
    // More concise
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode helper(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preOrder[preStart]);
        int index = map.get(root.val);
        int leftNum = index - inStart;
        int rightNum = inEnd - index;
        root.left = helper(preOrder, preStart + 1, preStart + leftNum + 1, inOrder, inStart, index - 1, map);
        root.right = helper(preOrder, preStart + leftNum + 1, preEnd, inOrder, index + 1, inEnd, map);
        return root;
    }
}
