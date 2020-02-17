package com.LeetCode.Easy12;

public class P783_MinimumDistanceBetweenBSTNodes {
    int prev=Integer.MIN_VALUE;
    int ans = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if (root ==null ) return -1;
        minDiffInBST(root.left);
        if (prev != Integer.MIN_VALUE) {
            ans = Math.min(ans, root.val - prev);
        }
        prev = root.val;
        minDiffInBST(root.right);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(
                new P783_MinimumDistanceBetweenBSTNodes().minDiffInBST(
                        StringToTreeNode.stringToTreeNode("4,2,6,1,3")
                )
        );
    }
}
