package com.hackersolve.leetcode.tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal {

    //list of all nodes of the parent level
    List<TreeNode> nodes = new ArrayList<TreeNode>();

    //data structure for holding all the nodes, level wise
    List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();

    //calculate the level order of the nodes
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null)
            return levelOrderList;

        //add the root node
        nodes.add(root);

        while (!nodes.isEmpty()) {

            //stores the values of the current node
            List<Integer> currentNodeValueList = new ArrayList<Integer>();

            //stores the child node reference
            List<TreeNode> childNodeList = new ArrayList<TreeNode>();

            for (TreeNode node : nodes) {
                if (node.left != null)
                    childNodeList.add(node.left);
                if (node.right != null)
                    childNodeList.add(node.right);
                currentNodeValueList.add(node.val);
            }
            //adds the current nodes to the level order list
            levelOrderList.add(currentNodeValueList);

            //the new parent level is assigned
            nodes = childNodeList;
        }
        return levelOrderList;
    }
}
