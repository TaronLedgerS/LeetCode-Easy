package com.LeetCode.Easy10;

public class P687_LongestUnivaluePath {
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        findEdgeLength(root);
        return ans;
    }
    private int findEdgeLength(TreeNode root) {
        if (root == null) return 0;
        int left = findEdgeLength(root.left);
        int right = findEdgeLength(root.right);
        int arrowLeft = 0, arrowRight = 0;
        if (root.left != null && root.left.val == root.val) {
            arrowLeft += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
    public static void main(String[] args) {
        System.out.println(
                new P687_LongestUnivaluePath().longestUnivaluePath(
                        StringToTreeNode.stringToTreeNode("5,4,5,1,1,null,5")
                )
        );
    }
}
