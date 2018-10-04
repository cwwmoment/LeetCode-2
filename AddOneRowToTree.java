/**
 * Created on 5 Oct 2018 by happygirlzt
 *
 * LeetCode #623. Add One Row to Tree
 */

public class AddOneRowToTree {
    // 难得AC了一道题呀，虽然WA了好几次。。
    // 我老是记不得注意q.size()，这个问题，因为添加了新的TreeNode之后
    // q.size()是会变动的，所以一定要存一个变量
    // 我的做法是迭代，用queue
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) return root;

        TreeNode dummy = root;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int dep = 1;

        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            newRoot.right = null;
            return newRoot;
        }

        if (d == dep + 1) {
            TreeNode oriLeft = root.left;
            TreeNode oriRight = root.right;
            root.left = new TreeNode(v);
            root.right = new TreeNode(v);
            root.left.left = oriLeft;
            root.right.right = oriRight;
        }

        while (!q.isEmpty()) {
            boolean flag = false;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();

                if (cur.left != null) {
                    q.offer(cur.left);
                    flag = true;
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                    flag = true;
                }
            }

            if (flag == true) {
                dep++;
            }

            if (dep + 1 == d) {
                break;
            }
        }

            while (!q.isEmpty()) {
                TreeNode cur = q.poll();
                TreeNode oriLeft = cur.left;
                TreeNode oriRight = cur.right;
                cur.left = new TreeNode(v);
                cur.right = new TreeNode(v);
                cur.left.left = oriLeft;
                cur.right.right = oriRight;
            }

            return dummy;
    }

    // Other's recursive solution
    public TreeNode addOneRow1(TreeNode root, int v, int d) {
        d--;
        if (d == 0) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            root = newRoot;
        } else {
            helper(root, v, d - 1);
        }

        return root;
    }

    public void helper(TreeNode root, int v, int d) {
        if (d == 0) {
            if (root.left != null) {
                TreeNode newNode = new TreeNode(v);
                newNode.left = root.left;
                root.left = newNode;
            } else {
                root.left = new TreeNode(v);
            }

            if (root.right != null) {
                TreeNode newNode = new TreeNode(v);
                newNode.right = root.right;
                root.right = newNode;
            } else {
                root.right = new TreeNode(v);
            }
        } else {
            if (root.left != null) helper(root.left, v, d - 1);
            if (root.right != null) helper(root.right, v, d - 1);
        }
    }

    // 和我算法一样的，别人的简洁写法
    public TreeNode addOneRow2(TreeNode root, int v, int d) {
        TreeNode node = null;
        if (d == 1) {
            node = new TreeNode(v);
            node.left = root;
            return node;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        d--;
        while (!q.isEmpty()) {
            d--;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                node = q.poll();
                if (d == 0) {
                    TreeNode t1 = new TreeNode(v);
                    TreeNode t2 = new TreeNode(v);
                    t1.left = node.left;
                    t2.right = node.right;
                    node.left = t1;
                    node.right = t2;
                }

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return root;
    }
}
