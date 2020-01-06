package com.LeetCode.Easy6;

import java.util.LinkedList;
import java.util.Queue;

public class P404_SumofLeftLeaves {
    //字符串构造二叉树
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return  0;
        }
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {//为左叶子节点
            sum += root.left.val;
        } else {//为空或者非叶子节点
            sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public static void main(String[] args) {
        P404_SumofLeftLeaves test = new P404_SumofLeftLeaves();
//"3,9,20,null,null,15,7"
        System.out.println(test.sumOfLeftLeaves(stringToTreeNode("1,null,2,2")));
    }
}
