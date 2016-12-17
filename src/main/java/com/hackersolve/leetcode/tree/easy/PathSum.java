package com.hackersolve.leetcode.tree.easy;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum {

    //checks if there is a path from the the root to the leaf
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                return true;
            }
        }
        return calculateSum(root, sum, false);
    }

    //calculate the sum by traversing the tree
    private boolean calculateSum(TreeNode root, int sum, boolean leaf) {

        if (root == null && sum == 0 && leaf == true)
            return true;
        else if (root == null)
            return false;

        //updates the value of the sum for computing left and right sum
        int updatedValue = sum - root.val;

        if (root.left != null || root.right != null)
            leaf = false;
        else
            leaf = true;
        return calculateSum(root.left, updatedValue, leaf)
                        || calculateSum(root.right, updatedValue, leaf);
    }
}