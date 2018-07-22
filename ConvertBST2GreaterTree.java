
public class ConvertBST2GreaterTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int sum = 0;
	public TreeNode convertBST(TreeNode root) {
         if (root == null) return root;
         
         convertBST(root.right);
         root.val += sum;
         sum = root.val;
         convertBST(root.left);
         return root;
	}
}
