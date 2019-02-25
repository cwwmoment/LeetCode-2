/**
 * LeetCode # 113. Path Sum II
 *
 * Created on 2018-08-26
 *
 * @author happygirlzt
 */

import java.util.LinkedList;
import java.util.List;

public class PathSum2 {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();

        if (root == null)
            return res;

        List<Integer> l = new LinkedList<>();
        helper(root, res, l, sum);
        return res;
    }


    public static void helper(TreeNode root, List<List<Integer>> res, List<Integer> list, int sum) {
        if (root == null)
            return;

        list.add(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new LinkedList<Integer> (list));
            list.remove(list.size() - 1);
            return;
        }

        if (root.left != null) {
            helper(root.left, res, list, sum - root.val);
        }
        if (root.right != null) {
            helper(root.right, res, list, sum - root.val);
        }
        list.remove(list.size() - 1);
    }

    // Updated on 4 Dec 2018
    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(root.val);

        helper(root, res, tmp, root.val, sum);

        return res;
    }

    public void helper1(TreeNode root, List<List<Integer>> res, List<Integer> tmp, int cur, int sum) {
        if (root != null && root.left == null && root.right == null &&
            cur == sum) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }

        if (root.left != null) {
            tmp.add(root.left.val);
            helper1(root.left, res, tmp, cur + root.left.val, sum);
            tmp.remove(tmp.size() - 1);
        }

        if (root.right != null) {
            tmp.add(root.right.val);
            helper1(root.right, res, tmp, cur + root.right.val, sum);
            tmp.remove(tmp.size() - 1);
        }
    }

    // Updated on 25 Feb 2019
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> tmp = new ArrayList<>();
       // tmp.add(root.val);
        helper(res, tmp, root, sum);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> tmp, TreeNode root, int sum) {
        if (root == null) return;
        tmp.add(root.val);
        
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                res.add(new ArrayList(tmp));
            }
           // return;
        }
        
       // if (root.left != null) {
        //    tmp.add(root.left.val);
            helper(res, tmp, root.left, sum - root.val);
       //     tmp.remove(tmp.size() - 1);
       // }
        
       // if (root.right != null) {
        //    tmp.add(root.right.val);
            helper(res, tmp, root.right, sum - root.val);
            tmp.remove(tmp.size() - 1);
       // }
    }
}
