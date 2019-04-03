package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by achaudhary on 4/2/19.
 */
/*
Inorder Traversal of Cartesian Tree
Asked in:
Amazon
Given an inorder traversal of a cartesian tree, construct the tree.

 Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree.
 Note: You may assume that duplicates do not exist in the tree.
Example :

Input : [1 2 3]

Return :
          3
         /
        2
       /
      1
 */
public class InorderTraversalOfCartesianTree {

    public static void main(String ...args) {
        InorderTraversalOfCartesianTree inorderTraversalOfCartesianTree = new InorderTraversalOfCartesianTree();
        TreeNode treeNode = inorderTraversalOfCartesianTree.buildTree(new ArrayList<>(Arrays.asList(1, 2, 3)));
        System.out.println(treeNode);
    }

    public TreeNode buildTree(ArrayList<Integer> A) {
        return buildTree(A, 0, A.size()-1);
    }

    private TreeNode buildTree(ArrayList<Integer> a, int startIndex, int endIndex) {
        if(startIndex > endIndex) return null;
        int maxIndex = findMaxIndex(a, startIndex, endIndex);
        TreeNode root = null;
        if(maxIndex > -1) {
            root = new TreeNode(a.get(maxIndex));
            root.left = buildTree(a, startIndex, maxIndex - 1);
            root.right = buildTree(a, maxIndex + 1, endIndex);
        }
        return root;
    }

    private int findMaxIndex(ArrayList<Integer> a, int startIndex, int endIndex) {
        int i = -1;
        int max = Integer.MIN_VALUE;
        for (int j = startIndex; j <= endIndex; j++) {
            if(a.get(j) > max) {
                max = a.get(j);
                i = j;
            }
        }
        return i;
    }


}
