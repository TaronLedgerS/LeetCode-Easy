package com.LeetCode.Easy2;

public class P108_ConvertSortedArraytoBinarySearchTreeTest {
    public static void main(String[] args){
        ConvertSortedArraytoBinarySearchTree temp = new ConvertSortedArraytoBinarySearchTree();
        int[] nums = {-3,0,1,2,3,11} ;
        TreeNode ANS = temp.sortedArrayToBST(nums);
        BinaryTreeLevelOrderTraversalII temp1 = new BinaryTreeLevelOrderTraversalII();
        System.out.println(temp1.levelOrderBottom(ANS));
    }
}
class ConvertSortedArraytoBinarySearchTree {
    TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        return  helper(num, 0, num.length - 1);
    }

     private  TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }
}