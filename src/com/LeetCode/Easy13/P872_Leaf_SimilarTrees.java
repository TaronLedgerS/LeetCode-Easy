package com.LeetCode.Easy13;

import java.util.ArrayList;
import java.util.List;

public class P872_Leaf_SimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        dfs(root1, leaf1);
        dfs(root2, leaf2);
        if (leaf1.size() != leaf2.size())
            return false;
        for (int i = 0; i < leaf1.size();i++) {
            if (!leaf1.get(i).equals(leaf2.get(i)))
                return false;
        }
        return true;
    }
    private void dfs(TreeNode root, List<Integer> leaf) {
        if (root.left!=null) dfs(root.left, leaf);
        if (root.right!=null) dfs(root.right, leaf);
        if (root.left==null&&root.right==null) leaf.add(root.val);
    }
    public static void main(String[] args) {
        System.out.println(
                new P872_Leaf_SimilarTrees().leafSimilar(
                        StringToTreeNode.stringToTreeNode("3,5,1,6,2,9,2,null,null,7,4"),
                        StringToTreeNode.stringToTreeNode("3,5,1,2,4,9,2,6,7")
                )
        );
    }
}
