# Tree
## Simple pattern
1. Invert Binary Tree
```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
```

2. Merge Two Binary Trees
```java
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
}
```

3. Same Tree
```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) return q == null;
        if (q == null) return p == null;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```

4. Sum of Left Leaves
```java
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        } else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
}
```

5. Tree Traversal
- Binary Tree Postorder Traversal
```java

```

## Path related
1. Path Sum- From root to leaf
```java
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
```

2. Path Sum 2
```java
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), root, sum);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, TreeNode root, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null && sum == root.val) {
            cur.add(sum);
            res.add(new ArrayList(cur));
            cur.remove(cur.size() - 1);
            return;
        }
        cur.add(root.val);
        helper(res, cur, root.left, sum - root.val);
        helper(res, cur, root.right, sum - root.val);
        cur.remove(cur.size() - 1);
    }
}
```

3. Path Sum3
```java
class Solution {
    public int pathSum(TreeNode root, int sum) {
        // edge cases
        if (root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int helper(TreeNode root, int sum) {
        int res = 0;
        if (root == null) return 0;
        if (root.val == sum) {
            res++;
        }

        res += helper(root.left, sum - root.val);
        res += helper(root.right, sum - root.val);
        return res;
    }
}
```

## DP
1. Unique Binary Search Tree
```java
class Solution {
    public int numTrees(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
```

## BST
1. Lowest Common Ancestor of a BST
```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
```
