package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by achaudhary on 4/2/19.
 */
/*
ZigZag Level Order Traversal BT
Asked in:
Amazon
Microsoft
Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return

[
         [3],
         [20, 9],
         [15, 7]
]
 */
public class ZigZagTraversal {

    public static void main(String ...args) {
        TreeCreation treeCreation = new TreeCreation();
//        TreeNode root = treeCreation.createTree("11 1 2 3 -1 -1 4 -1 -1 5 -1 -1");
        TreeNode root = treeCreation.createTree("19 3 4 10 7 6 8 11 2 -1 5 -1 -1 -1 -1 -1 -1 -1 -1 -1");
        ZigZagTraversal zigZagTraversal = new ZigZagTraversal();
        ArrayList<ArrayList<Integer>> arrayLists = zigZagTraversal.zigzagLevelOrder(root);
        System.out.println(arrayLists);

    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        Deque<TreeNode> currentDeque = new LinkedList<>();
        Deque<TreeNode> nextLevelDeque = new LinkedList<>();

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean isForward = true;
        if(A != null) {
            currentDeque.offer(A);
            ArrayList<Integer> currentLevelList = new ArrayList<>();
            while(!currentDeque.isEmpty()) {
                if(isForward) {
                    TreeNode treeNode = currentDeque.pollFirst();
                    TreeNode left = treeNode.left;
                    TreeNode right = treeNode.right;
                    if(left != null) nextLevelDeque.offerLast(left);
                    if(right != null) nextLevelDeque.offerLast(right);
                    currentLevelList.add(treeNode.val);
                } else {
                    TreeNode treeNode = currentDeque.pollLast();
                    TreeNode left = treeNode.left;
                    TreeNode right = treeNode.right;
                    if(right != null) nextLevelDeque.offerFirst(right);
                    if(left != null) nextLevelDeque.offerFirst(left);
                    currentLevelList.add(treeNode.val);
                }

                if(currentDeque.isEmpty()) {
                    currentDeque = nextLevelDeque;
                    nextLevelDeque = new LinkedList<>();
                    isForward = !isForward;
                    result.add(currentLevelList);
                    currentLevelList = new ArrayList<>();
                }
            }
        }

        return result;
    }
}
