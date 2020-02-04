package com.LeetCode.Easy8;

public class P563_BinaryTreeTilt {
    int sumofTilt = 0;
    public int findTilt(TreeNode root) {
        postOrder(root);
        return sumofTilt;
    }
    private int postOrder(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int sumofLeft = postOrder(root.left);
        int sumofRight = postOrder(root.right);
        sumofTilt += Math.abs(sumofLeft - sumofRight);
        return sumofLeft + sumofRight + root.val;
    }
    public static void main(String[] args) {
        System.out.println(
                new P563_BinaryTreeTilt().findTilt(
                        StringToTreeNode.stringToTreeNode("1,2,3,4,5,null,null,6")
                )
        );
    }
}
