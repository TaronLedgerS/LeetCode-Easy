package com.LeetCode.Easy15;

public class P1022_SumofRootToLeafBinaryNumbers {
    int ans = 0;
    public int sumRootToLeaf(TreeNode root) {

        if (null!=root) dfs(root, 0);
        return ans ;
    }

    private void dfs(TreeNode root,int nums) {
        nums = (nums << 1) + root.val;
        if (null == root.left && null == root.right) {
            ans += nums;
        }
        if (root.left != null) {
            dfs(root.left,nums);
        }
        if (root.right != null) {
            dfs(root.right, nums);
        }
    }
}
