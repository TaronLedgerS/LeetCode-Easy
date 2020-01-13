package com.LeetCode.Easy8;

public class P543_DiameterofBinaryTree {
    int longest = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getTreeHeight(root);
        return longest;
    }
    public int getTreeHeight(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int leftHeight = getTreeHeight(root.left) + 1;
        int rightHeight = getTreeHeight(root.right) + 1;
        longest = Math.max(longest, leftHeight+rightHeight-2);
        return Math.max(leftHeight, rightHeight);
    }
    public static void main(String[] args) {
        System.out.println(
                new P543_DiameterofBinaryTree().diameterOfBinaryTree(
                        StringToTreeNode.stringToTreeNode("1,2,3,4,5,null,null,6")
                )
        );
    }
}
