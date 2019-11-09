package com.LeetCode.Easy4;

public class P235_LowestCommonAncestorofBSTTest {
    public static void main(String[] args) {
        //todo 构建一个二叉查找树
    }
}


class  LCAofBST{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}