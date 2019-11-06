package com.LeetCode.Easy4;

public class P226_InvertBinaryTreeTest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode tleft = new TreeNode(2);
        TreeNode tright = new TreeNode(7);
        root.left = tleft;
        root.right = tright;
        tleft.left = new TreeNode(1);
        tleft.right = new TreeNode(3);
        tright.left = new TreeNode(6);
        tright.right = new TreeNode(9);
        System.out.println(root.left.right.val+" "+root.right.left.val);
        InvertBinaryTree a = new InvertBinaryTree();
        a.invertTree(root);
        System.out.println(root.left.right.val+" "+root.right.left.val);
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class InvertBinaryTree {

     TreeNode invertTree(TreeNode root) {
         if(null == root){
             return null;
         }
        TreeNode tleft = invertTree(root.left);
        TreeNode tright = invertTree(root.right);
        root.left = tright;
        root.right = tleft;
        return root;
    }
}