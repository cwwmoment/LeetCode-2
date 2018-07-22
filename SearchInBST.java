
public class SearchInBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null)
			return root;

		TreeNode node = new TreeNode(0);

        if (root.val == val) node = root;
        
		if (root.val < val) {
			node = searchBST(root.right, val);
		}

		if (root.val > val) {
			node = searchBST(root.left, val);
		}

		return node;
	}

	public static void main(String[] agrs) {

	}
}
