package com.LeetCode.Easy13;

import java.util.ArrayList;
import java.util.List;

public class P897_IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        Inorder(root,vals);

        TreeNode Node = new TreeNode(vals.get(0));
        TreeNode newRoot = Node;
        for(int i = 1;i<vals.size();i++){
            Node.right = new TreeNode(vals.get(i));
            Node = Node.right;
        }
        return newRoot;
    }
    private void Inorder(TreeNode root, List<Integer> vals){
        if(root==null) return;
        Inorder(root.left,vals);
        vals.add(root.val);
        Inorder(root.right,vals);
    }
}
