package com.LeetCode.Easy9;

public class P606_ConstructStringfromBinaryTree {
    StringBuilder treeStr = new StringBuilder();
    public String tree2str(TreeNode t) {
        if (t != null) {
            preorder(t);
        }
        return treeStr.toString();
    }
    private void preorder(TreeNode t) {
        if (t == null) {
            return;
        }
        treeStr.append(t.val);
        if (t.left == null && t.right == null) {
            return;
        }
        treeStr.append("(");
        if (t.left != null) {
            preorder(t.left);
        }
        treeStr.append(")");
        if ( t.right != null) {
            treeStr.append("(");
            preorder(t.right);
            treeStr.append(")");
        }
    }
    public static void main(String[] args) {
        System.out.println(
                new P606_ConstructStringfromBinaryTree().tree2str(
                        StringToTreeNode.stringToTreeNode("1,2,3,4")
                )
        );
    }
}
