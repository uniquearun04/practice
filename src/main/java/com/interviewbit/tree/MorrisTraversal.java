package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by achaudhary on 4/1/19.
 */
public class MorrisTraversal {

    public static void main(String ...args) {
        TreeCreation treeCreation = new TreeCreation();
        TreeNode tree = treeCreation.createTree("19 7 4 10 3 6 8 11 2 -1 5 -1 -1 -1 -1 -1 -1 -1 -1 -1");
        MorrisTraversal morrisTraversal = new MorrisTraversal();
        List<Integer> morrisInorderTraversal = morrisTraversal.getMorrisInorderTraversal(tree);
        System.out.println(morrisInorderTraversal);
        tree = treeCreation.createTree("19 7 4 10 8 6 3 11 2 -1 5 -1 -1 -1 -1 -1 -1 -1 -1 -1");
        morrisInorderTraversal = morrisTraversal.getMorrisInorderTraversal(tree);
        System.out.println(morrisInorderTraversal);
    }

    public List<Integer> getMorrisInorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        TreeNode current = root;
        while(current != null) {
            TreeNode left = current.left;
            if(left != null) {
                TreeNode predecessor = getInorderPredecessor(current);
                if(predecessor.right == null) {
                    predecessor.right = current;
                    current = left;
                } else {
                    predecessor.right = null;
                    inorderList.add(current.val);
                    current = current.right;
                }
            } else {
                inorderList.add(current.val);
                current = current.right;
            }
        }
        return inorderList;
    }

    public List<TreeNode> getMorrisInorderTraversalList(TreeNode root) {
        List<TreeNode> inorderList = new ArrayList<>();
        TreeNode current = root;
        while(current != null) {
            TreeNode left = current.left;
            if(left != null) {
                TreeNode predecessor = getInorderPredecessor(current);
                if(predecessor.right == null) {
                    predecessor.right = current;
                    current = left;
                } else {
                    predecessor.right = null;
                    inorderList.add(current);
                    current = current.right;
                }
            } else {
                inorderList.add(current);
                current = current.right;
            }
        }
        return inorderList;
    }

    public TreeNode getInorderPredecessor(TreeNode node) {
        TreeNode left = node.left;
        if(left == null) return null;
        TreeNode current = left;
        while(current.right != null && node != current.right) {
            current = current.right;
        }
        return current;
    }
}
