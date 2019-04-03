package com.interviewbit.tree;

import java.util.*;

/**
 * Created by achaudhary on 3/22/19.
 */
/*
Given a binary tree, return a 2-D array with vertical order traversal of it.
Go through the example and image for more details.

Example :
Given binary tree:

      6
    /   \
   3     7
  / \     \
 2   5     9
returns

[
    [2],
    [3],
    [6 5],
    [7],
    [9]
]


Note : If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
 */
public class VerticalOrderTraversal {

    public static void main(String ...args) {
        TreeCreation treeCreation = new TreeCreation();
//        TreeNode root = treeCreation.createTree("11 1 2 3 -1 -1 4 -1 -1 5 -1 -1");
        TreeNode root = treeCreation.createTree("7 6 3 7 2 5 -1 9");
        VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();
        ArrayList<ArrayList<Integer>> result = verticalOrderTraversal.verticalOrderTraversal(root);
        System.out.println(result);
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();
        Queue<TreeNodeWithHD> queue = new LinkedList<>();
        queue.add(new TreeNodeWithHD(0, A));
        while(!queue.isEmpty()) {
            TreeNodeWithHD treeNodeWithHD = queue.poll();
            int horizontalDistance = treeNodeWithHD.horizontalDistance;
            ArrayList<Integer> list = treeMap.get(horizontalDistance);
            if(list == null) {
                list = new ArrayList<>();
                treeMap.put(horizontalDistance, list);
            }

            TreeNode treeNode = treeNodeWithHD.treeNode;
            if(treeNode == null) {
                System.out.println("----- hd: "+treeNodeWithHD.horizontalDistance);
            }
            list.add(treeNode.val);
            addTreeNodeToQueue(treeNode.left, horizontalDistance -1, queue);
            addTreeNodeToQueue(treeNode.right, horizontalDistance +1, queue);
        }

        Set<Integer> keySet = treeMap.keySet();
        for(Integer key : keySet) {
            result.add(treeMap.get(key));
        }

        return result;
    }

    private void addTreeNodeToQueue(TreeNode node, int hd, Queue<TreeNodeWithHD> queue) {
        if(node != null) {
            queue.add(new TreeNodeWithHD(hd, node));
        }
    }



    private static class TreeNodeWithHD{
        int horizontalDistance;
        TreeNode treeNode;

        public TreeNodeWithHD(int hd, TreeNode node) {
            this.horizontalDistance = hd;
            this.treeNode = node;
        }

    }

}
