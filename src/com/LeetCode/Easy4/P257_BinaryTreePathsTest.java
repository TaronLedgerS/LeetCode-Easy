package com.LeetCode.Easy4;

import java.util.ArrayList;
import java.util.List;

public class P257_BinaryTreePathsTest {
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
        BinaryTreePaths btp = new BinaryTreePaths();
        List<String> ans = btp.binaryTreePaths(root);
        for (String s : ans) {
            System.out.println(s);
        }

    }
}

class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root!=null)   searchBT(root, "", ans);
        return ans;
    }
    private void searchBT(TreeNode node, String path, List<String> ans) {
        if (node.left == null && node.right == null) {
            path += node.val;
            ans.add(path);
        }
        if (node.left != null) {
            searchBT(node.left,path+node.val + "->",ans);
        }
        if (node.right != null) {
            searchBT(node.right, path+node.val + "->", ans);
        }
    }
}
