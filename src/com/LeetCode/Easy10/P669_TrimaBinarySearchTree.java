package com.LeetCode.Easy10;

public class P669_TrimaBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val<L) return trimBST(root.right,L,R);
        if (root.val > R) return trimBST(root.left, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
    public static void main(String[] args) {
        System.out.println(
                new P669_TrimaBinarySearchTree().trimBST(
                        StringToTreeNode.stringToTreeNode("2,0,3,-4,1"),-1,3
                )
        );
    }
}
