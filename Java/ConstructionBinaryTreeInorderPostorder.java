
public class ConstructionBinaryTreeInorderPostorder {
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return helper(0, inorder.length - 1, 0, inorder.length - 1, inorder, postorder);
	}
	
	public TreeNode helper(int postStart, int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
		if (postStart > postorder.length - 1 || inStart >= inEnd) {
			return null;
		}
		
		int inIndex = postorder.length - 1;
		TreeNode root = new TreeNode(postorder[postEnd]);
		
		for (int i = inStart; i < inEnd; i++) {
			if (inorder[i] == root.val) {
				inIndex = i;
				break;
			}
		}
		
		root.left = helper(postStart, postStart + inIndex - inStart - 1, inStart, inIndex - 1, inorder, postorder);
		root.right = helper(postStart + inIndex - inStart, postEnd - 1, inIndex + 1, inEnd, inorder, postorder);
		
		return root;
	}
}
