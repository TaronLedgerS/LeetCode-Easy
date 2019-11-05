package com.LeetCode.Easy2;

public class P110_BalancedBinaryTreeTest {
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

        BalancedBinaryTree temp = new BalancedBinaryTree();
        System.out.println(temp.isBalanced(l1));
    }
}
class BalancedBinaryTree {
        private boolean result = true;

         boolean isBalanced(TreeNode root) {
            maxDepth(root);
            return result;
        }

        private int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            if (Math.abs(l - r) > 1)
                result = false;
            return 1 + Math.max(l, r);
        }

}
