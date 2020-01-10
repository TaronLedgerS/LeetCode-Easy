package com.LeetCode.Easy8;

public class P538_ConvertBSTtoGreaterTree {
    int sum =0;
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
    public void convert(TreeNode root) {
        if (root == null) {
            return;
        }
        convert(root.right);
        sum += root.val;
        root.val = sum;
        convert(root.left);
    }
    public static void main(String[] args) {
        System.out.println(new P538_ConvertBSTtoGreaterTree().convertBST(
                StringToTreeNode.stringToTreeNode("5,2,13")
        ));
    }
}
