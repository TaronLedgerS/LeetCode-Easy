package com.LeetCode.Easy10;

import java.util.*;

public class P653_TwoSumIV_InputisaBST {
    //1.HashSet+DFS
    public boolean findTarget1(TreeNode root, int k) {
        Set<Integer> nodeSet = new HashSet<>();
        return preorderTraversal(root, nodeSet,k);
    }
    private boolean preorderTraversal(TreeNode root, Set<Integer> nodeSet,int k) {
        if (root==null) return false;
        if (nodeSet.contains(k - root.val))
            return true;
        nodeSet.add(root.val);
        return preorderTraversal(root.left,nodeSet,k)|| preorderTraversal(root.right,nodeSet,k);
    }
    //2.HashSet+BFS
    public boolean findTarget2(TreeNode root, int k) {
        if (root==null) return false;
        Set<Integer> nodeSet = new HashSet<>();
        Queue<TreeNode> toTraversal = new LinkedList<>();
        toTraversal.add(root);
        while (!toTraversal.isEmpty()) {
            TreeNode node = toTraversal.remove();
            if (nodeSet.contains(k - node.val)) {
                return true;
            }
            nodeSet.add(node.val);
            if (node.left!=null) toTraversal.add(node.left);
            if (node.right!=null) toTraversal.add(node.right);
        }
        return false;
    }
    //3.BST中序遍历是有序的+双指针
    public boolean findTarget3(TreeNode root, int k) {
        List<Integer> valArray = new ArrayList<>();
        inorder(root, valArray);
        int l = 0, r = valArray.size() - 1;
        while (l < r) {
            int sum = valArray.get(l) + valArray.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    private void inorder(TreeNode root, List<Integer> valArray) {
        if (root == null) {
            return;
        }
        inorder(root.left, valArray);
        valArray.add(root.val);
        inorder(root.right,valArray);
    }
    public static void main(String[] args) {
        System.out.println(
                new P653_TwoSumIV_InputisaBST().findTarget1(
                        StringToTreeNode.stringToTreeNode("2,0,3,-4,-1"),-1
                )
        );
        System.out.println(
                new P653_TwoSumIV_InputisaBST().findTarget2(
                        StringToTreeNode.stringToTreeNode("2,0,3,-4,-1"),-1
                )
        );
        System.out.println(
                new P653_TwoSumIV_InputisaBST().findTarget3(
                        StringToTreeNode.stringToTreeNode("5,3,6,2,4,null,7"),9
                )
        );
    }
}
