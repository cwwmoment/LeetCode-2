/**
 * Created on 21 Feb 2019 by happygirlzt
 * 
 * LeetCode #545. Boundary of Binary Tree 
 */

class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        if (!isLeaf(root)) res.add(root.val);
        
        TreeNode t = root.left;
        while (t != null) {
            if (!isLeaf(t)) {
                res.add(t.val);
            }
            
            if (t.left != null) {
                t = t.left;
            } else {
                t = t.right;
            }
        }
        
        addLeaves(res, root);
        Deque<Integer> stack = new ArrayDeque<>();
        t = root.right;
        while (t != null) {
            if (!isLeaf(t)) {
                stack.push(t.val);
            }
            
            if (t.right != null) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
        
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        
        return res;
    }
    
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
    
    private void addLeaves(List<Integer> res, TreeNode root) {
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        } else {
            if (root.left != null) {
                addLeaves(res, root.left);
            }
            
            if (root.right != null) {
                addLeaves(res, root.right);
            }
        }
    }
}