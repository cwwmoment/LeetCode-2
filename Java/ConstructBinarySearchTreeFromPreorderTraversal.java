/**
 * Created on 15 Apr 2019 by happygirlzt
 *
 * LeetCode #1008. Construct Binary Search Tree from Preorder Traversal
 *
 */

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Map<Integer, Integer> inMap = new HashMap<>();
        Arrays.sort(inorder);
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        // inorder 1, 5, 7, 8, 10, 12
        // preorder 8, 5, 1, 7, 10, 12
        return buildTree(inMap, preorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode buildTree(Map<Integer, Integer> inMap, int[] preorder, int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart > inEnd ||
            preStart > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = inMap.get(preorder[preStart]);
        int leftNum = rootIndex - inStart;
        root.left = buildTree(inMap, preorder, inStart, rootIndex - 1, preStart + 1, preStart + leftNum);
        root.right = buildTree(inMap, preorder, rootIndex + 1, inEnd, preStart + 1 + leftNum, preEnd);

        return root;
    }

    // Optimized
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        int i = start + 1;
        for (; i <= end; i++) {
            if (preorder[i] > preorder[start]) break;
        }
        root.left = helper(preorder, start + 1, i - 1);
        root.right = helper(preorder, i, end);
        return root;
    }
}
