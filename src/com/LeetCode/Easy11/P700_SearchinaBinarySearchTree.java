package com.LeetCode.Easy11;


public class P700_SearchinaBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = (val < root.val) ? root.left : root.right;
        }
        return root;
    }
    public static void main(String[] args) {
        System.out.println(
                new P700_SearchinaBinarySearchTree().searchBST(
                        StringToTreeNode.stringToTreeNode("4,2,7,1,3"),5
                )
        );
    }
}
