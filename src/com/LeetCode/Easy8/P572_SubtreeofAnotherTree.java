package com.LeetCode.Easy8;

public class P572_SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (isSame(s, t)) return true;
        if(s==null) return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null)  return true;
        if (s == null||t==null) return false;
        if (s.val != t.val)  return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
    public static void main(String[] args) {
        System.out.println(
                new P572_SubtreeofAnotherTree().isSubtree(
                        StringToTreeNode.stringToTreeNode("3,4,5,1,2"),
                        StringToTreeNode.stringToTreeNode("4,1,2")
                )
        );
    }
}
