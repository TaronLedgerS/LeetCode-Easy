package com.LeetCode.Easy2;

public class P101_SymmetricTreeTest {
    public static void main(String[] args){
        TreeNode l1 = new TreeNode (1);
        TreeNode  a = new TreeNode (2);
        TreeNode  b = new TreeNode (2);
        l1.left = a;
        l1.right = b;
        a.left = new TreeNode (3);
        a.right = new TreeNode (3);
        b.left = new TreeNode (4);
        b.right = new TreeNode (3);

        SymmetricTree temp = new SymmetricTree();
        System.out.println(temp.isSymmetric(l1));
    }
}
class SymmetricTree {
    boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    private  boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}
