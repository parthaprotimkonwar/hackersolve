package com.hackersolve.tree.medium.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

public class PopulateRightPointers {

    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        levelOrder(root);
    }

    List<TreeLinkNode> nodes = new ArrayList<TreeLinkNode>();

    //level order tree traversal for introducing the right pointers
    void levelOrder(TreeLinkNode root) {

        //Level order parent nodes
        List<TreeLinkNode> parentNodeList = new ArrayList<TreeLinkNode>();

        //adding the root node
        //base case
        nodes.add(root);
        while (!nodes.isEmpty()) {

            TreeLinkNode previousNode = null;
            //traversing through all the nodes of the parent
            for (TreeLinkNode currentNode : nodes) {
                //assigning the right pointers
                if (previousNode != null) {
                    previousNode.next = currentNode;
                }
                //keeping a track of the current node
                previousNode = currentNode;

                //adding the left and right child nodes to the parentNodeList
                if (currentNode.left != null)
                    parentNodeList.add(currentNode.left);
                if (currentNode.right != null)
                    parentNodeList.add(currentNode.right);
            }
            //resetting the values for the next level order parsing
            nodes = parentNodeList;
            parentNodeList = new ArrayList<TreeLinkNode>();
        }
    }
}
