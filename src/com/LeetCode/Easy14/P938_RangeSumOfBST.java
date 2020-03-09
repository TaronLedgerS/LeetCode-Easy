package com.LeetCode.Easy14;

public class P938_RangeSumOfBST {
    public static void main(String[] args) {
        System.out.println(
                new RangeSumOfBST().rangeSumBST(
                        StringToTreeNode.stringToTreeNode("10,5,15,3,7,13,18,1,null,6"),6,10
                )
        );
    }
}

class RangeSumOfBST {
    int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root,L,R);
        return ans;
    }
    private void dfs(TreeNode root, int L,int R) {
        if (null==root) return;
        if (root.val>L) dfs(root.left, L, R);
        if (root.val>=L && root.val<=R) ans += root.val;
        if (root.val<R) dfs(root.right, L, R);
    }
}