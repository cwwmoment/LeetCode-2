
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
		
		helper(0, 0, inorder.length - 1, preorder, inorder);
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
}