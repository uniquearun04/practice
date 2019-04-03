package com.interviewbit.tree;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by achaudhary on 3/21/19.
 */
public class TreeCreation {

    public TreeNode createTree(String line) {
        String trim = line.trim();
        String[] split = trim.split(" ");
        int n = Integer.parseInt(split[0]);
        int [] nodes = new int[n];
        for (int i = 1; i < split.length; i++) {
            nodes[i-1] = Integer.parseInt(split[i]);
        }
        if(n <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(nodes[0]);

        List<TreeNode> currentLevelNodeList = new ArrayList<>();
        List<TreeNode> nextLevelNodeList = new ArrayList<>();

        currentLevelNodeList.add(root);
        int i = 0;
        int num1 = 0;
        int num2 = 0;
        while(!currentLevelNodeList.isEmpty() && i < n) {
            TreeNode node = currentLevelNodeList.remove(0);
            num1 = i < n -1 ? nodes[++i] : -1;
            num2 = i < n -1 ? nodes[++i] : -1;
            if(num1 != -1) {
                node.left = new TreeNode(num1);
                nextLevelNodeList.add(node.left);
            }
            if(num2 != -1) {
                node.right = new TreeNode(num2);
                nextLevelNodeList.add(node.right);
            }

            if(currentLevelNodeList.isEmpty()) {
                currentLevelNodeList = nextLevelNodeList;
                nextLevelNodeList = new ArrayList<>();
            }
        }


        return root;
    }


}
