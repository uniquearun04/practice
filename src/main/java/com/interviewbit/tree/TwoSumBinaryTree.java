package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by achaudhary on 4/2/19.
 */
/*
2-Sum Binary Tree
Asked in:
Amazon
Given a binary search tree T, where each node contains a positive integer, and an integer K, you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.

Return 1 to denote that two such nodes exist. Return 0, otherwise.

Notes

Your solution should run in linear time and not take memory more than O(height of T).
Assume all values in BST are distinct.
Example :

Input 1:

T :       10
         / \
        9   20

K = 19

Return: 1

Input 2:

T:        10
         / \
        9   20

K = 40

Return: 0
 */
public class TwoSumBinaryTree {

    public static void main(String ...args) {
        TreeCreation treeCreation = new TreeCreation();
//        TreeNode tree = treeCreation.createTree("7 10 9 20 -1 -1 -1 -1");
        TreeNode tree = treeCreation.createTree("7 14 1 20 -1 -1 -1 -1");

        TwoSumBinaryTree twoSumBinaryTree = new TwoSumBinaryTree();
        int t2Sum = twoSumBinaryTree.t2Sum(tree, 21);
        System.out.println(t2Sum);
    }

    public int t2Sum(TreeNode A, int B) {

        List<TreeNode> inorderList = getInorderTraversal(A);
        for(int i = 0, j = inorderList.size() - 1; i < j;  ) {
            int sum = inorderList.get(i).val + inorderList.get(j).val;
            if(sum == B) return 1;
            if(sum < B) i++;
            if(sum > B) j--;
        }
        return 0;
        // Stack<TreeNode> stack = new Stack<>();
        // stack.push(A);
        // TreeNode currNode;
        // while(!stack.isEmpty()) {
        //     currNode = stack.pop();
        //     if(currNode.val < B) {
        //         int diff = B - currNode.val;
        //         TreeNode found = findNode(A, diff);
        //         if(found != null && found != currNode) return 1;
        //     }
        //     TreeNode left = currNode.left;
        //     TreeNode right = currNode.right;
        //     if(left != null) stack.push(left);
        //     if(right != null) stack.push(right);
        // }
        // return 0;
    }

    public TreeNode findNode(TreeNode node, int a) {
        if(node == null) return null;
        if(node.val == a) return node;
        TreeNode result = findNode(node.left, a);
        if(result == null) {
            result = findNode(node.right, a);
        }
        return result;
    }

    List<TreeNode> getInorderTraversal(TreeNode node) {
        List<TreeNode> result = new ArrayList<>();
        findInorderTraversal(node, result);
        return result;
    }

    private void findInorderTraversal(TreeNode node, List<TreeNode> list) {
        if(node != null) {
            findInorderTraversal(node.left, list);
            list.add(node);
            findInorderTraversal(node.right, list);
        }
    }
}
