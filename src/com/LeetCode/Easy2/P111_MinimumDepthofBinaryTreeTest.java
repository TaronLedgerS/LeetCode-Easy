package com.LeetCode.Easy2;

import java.util.LinkedList;
import java.util.List;

public class P111_MinimumDepthofBinaryTreeTest {
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

        MinimumDepthofBinaryTree temp = new MinimumDepthofBinaryTree();
        System.out.println(temp.minDepth(l1));
    }
}
class MinimumDepthofBinaryTree {
     int minDepth(TreeNode root) {
        if(root == null) return 0;
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        int level = 1;
        while(!list.isEmpty()){
            int len = list.size();
            for(int i = 0;i<len;i++){
                TreeNode node = list.remove(0);
                if(node.left == null && node.right == null) return level;
                if(node.left != null) list.add(node.left);
                if(node.right != null) list.add(node.right);
            }
            level++;
        }
        return 0;// Will never reach this line;
    }
}
