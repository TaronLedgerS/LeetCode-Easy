package com.LeetCode.Easy14;

public class P965_UnivaluedBinaryTree {
    boolean univalued = true;
    int value;
    public boolean isUnivalTree(TreeNode root) {
        if (null == root) return true;
        value = root.val;
        preorder(root);
        return univalued;
    }
    private void preorder(TreeNode root) {
        if (null == root || !univalued) return;
        if (root.val!=value){
            univalued = false;
            return;
        }
        preorder(root.left);
        preorder(root.right);
    }
}
