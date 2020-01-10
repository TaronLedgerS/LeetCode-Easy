package com.LeetCode.Easy8;

public class P530_MinimumAbsoluteDifferenceinBST {
    int pre=-1;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        int leftmin = getMinimumDifference(root.left);
        int min = leftmin;
        if(pre!=-1) {
            min=Math.min(leftmin, root.val - pre);
        }
        pre = root.val;
        int rightmin = getMinimumDifference(root.right);
        min = Math.min(min, rightmin);
        return min;
    }
    public static void main(String[] args) {
        System.out.println(new P530_MinimumAbsoluteDifferenceinBST().getMinimumDifference(
                StringToTreeNode.stringToTreeNode("1,null,5,3")
        ));
    }
}
