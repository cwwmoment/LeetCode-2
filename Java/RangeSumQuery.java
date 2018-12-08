/**
 * Created on 8 Dec 2018 by happygirlzt
 * 
 * LeetCode #307. Range Sum Query - Mutable
 * 
 **/

// This problem is a typical usage of Segment Tree
class NumArray {

    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
        
    SegmentTreeNode root = null;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode res = new SegmentTreeNode(start, end);
            if (start == end) {
                res.sum = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                res.left = buildTree(nums, start, mid);
                res.right = buildTree(nums, mid + 1, end);
                res.sum = res.left.sum + res.right.sum;
            }
            
            return res;
        }
    }
    
    public void update(int i, int val) {
        update(root, i, val);
    }
    
    private void update(SegmentTreeNode root, int i, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (i <= mid) {
                update(root.left, i, val);
            } else {
                update(root.right, i, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    private int sumRange(SegmentTreeNode root, int i, int j) {
        if (j == root.end && root.start == i) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (j <= mid) {
                // left part
                return sumRange(root.left, i, j);
            } else if (i >= mid + 1) {
                // right part
                return sumRange(root.right, i, j);
            } else {
                // partially
                return sumRange(root.right, mid + 1, j) + sumRange(root.left, i, mid);
            }
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */