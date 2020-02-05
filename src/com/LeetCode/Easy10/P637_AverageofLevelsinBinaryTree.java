package com.LeetCode.Easy10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P637_AverageofLevelsinBinaryTree {
    List<Double> sumofEachLevel = new ArrayList<>();
    List<Integer> countofEachLevel = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        preorderTraversal(root, 0);
        for (int i = 0; i < sumofEachLevel.size(); i++) {
            sumofEachLevel.set(i, sumofEachLevel.get(i) / countofEachLevel.get(i));
        }
        return sumofEachLevel;
    }
    //DFS
    private void preorderTraversal(TreeNode root, int i) {
        if (root==null) return;
        if (sumofEachLevel.size() < i + 1) {
            sumofEachLevel.add(0.0);
            countofEachLevel.add(0);
        }
        sumofEachLevel.set(i, sumofEachLevel.get(i) + root.val);
        countofEachLevel.set(i, countofEachLevel.get(i) + 1);

        preorderTraversal(root.left, i + 1);
        preorderTraversal(root.right, i + 1);
    }
    //BFS
    public List<Double> averageOfLevelsBFS(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            double sum = 0.0;
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            result.add(sum / n);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                new P637_AverageofLevelsinBinaryTree().averageOfLevels(
                        StringToTreeNode.stringToTreeNode("1,2,3,4,5")
                )
        );
    }
}
