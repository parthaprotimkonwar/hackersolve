package com.hackersolve.tree.easy.leetcode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *      int val;
 *      TreeNode left;
 *      TreeNode right;
 *      TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree {

    //check if the tree is balanced or not
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (checkHeight(root) == -1)
            return false;
        return true;
    }

    //compute height between all the nodes recursively
    //checks if the absolute height between the two child nodes > 1
    private int checkHeight(TreeNode root) {
        if (root == null)
            return 0;

        //calculate the left height
        int leftHeight = checkHeight(root.left);
        //calculate the right height
        int rightHeight = checkHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        if (leftHeight == -1 || rightHeight == -1)
            return -1;
        //return the max height at this node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
