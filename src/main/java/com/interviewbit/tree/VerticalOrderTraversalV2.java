package com.interviewbit.tree;

import java.util.*;

/**
 * Created by achaudhary on 4/2/19.
 */
public class VerticalOrderTraversalV2 {

    public static void main(String ...args) {
        TreeCreation treeCreation = new TreeCreation();
//        TreeNode root = treeCreation.createTree("11 1 2 3 -1 -1 4 -1 -1 5 -1 -1");
        TreeNode root = treeCreation.createTree("19 3 4 10 7 6 8 11 2 -1 5 -1 -1 -1 -1 -1 -1 -1 -1 -1");
        VerticalOrderTraversalV2 verticalOrderTraversal = new VerticalOrderTraversalV2();
        ArrayList<ArrayList<Integer>> result = verticalOrderTraversal.verticalOrderTraversal(root);
        System.out.println(result);
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        TreeNodeWithHD treeWithHorizontalDistance = createTreeWithHorizontalDistance(A, 0, 0);
        TreeMap<Integer, List<TreeNodeWithHD>> treeMap = new TreeMap<>();
        insertTreeNodeWithHDIntoMap(treeMap, treeWithHorizontalDistance);
        Set<Integer> keySet = treeMap.keySet();
        keySet.forEach(key -> {
            List<TreeNodeWithHD> treeNodeWithHDs = treeMap.get(key);
            result.add(getValueList(treeNodeWithHDs));
        });
        return result;
    }

    ArrayList<Integer> getValueList(List<TreeNodeWithHD> treeNodeWithHDs) {
        ArrayList<Integer> result = new ArrayList<>();
        Collections.sort(treeNodeWithHDs, new Comparator<TreeNodeWithHD>() {
            @Override
            public int compare(TreeNodeWithHD o1, TreeNodeWithHD o2) {
                if(o1.depth < o2.depth) return -1;
                else if(o1.depth > o2.depth) return 1;
                return 0;
            }
        });
        if(treeNodeWithHDs != null) {
            treeNodeWithHDs.forEach(treeNodeWithHD -> {
                result.add(treeNodeWithHD.val);
            });
        }
        return result;
    }

    private void insertTreeNodeWithHDIntoMap(TreeMap<Integer, List<TreeNodeWithHD>> treeMap, TreeNodeWithHD treeNodeWithHD) {
        TreeNodeWithHD current = treeNodeWithHD;
        if(current != null) {
            TreeNodeWithHD left = current.left;
            TreeNodeWithHD right = current.right;
            int horizontalDistance = current.horizontalDistance;
            List<TreeNodeWithHD> treeNodeWithHDs = treeMap.get(horizontalDistance);
            if(treeNodeWithHDs == null) {
                treeNodeWithHDs = new ArrayList<>();
                treeMap.put(horizontalDistance, treeNodeWithHDs);
            }
            treeNodeWithHDs.add(current);
            insertTreeNodeWithHDIntoMap(treeMap, left);
            insertTreeNodeWithHDIntoMap(treeMap, right);
        }
    }

    private TreeNodeWithHD createTreeWithHorizontalDistance(TreeNode A, int hd, int depth) {
        if(A == null) return null;
        TreeNode left = A.left;
        TreeNode right = A.right;
        TreeNodeWithHD ahd = new TreeNodeWithHD(A, hd, depth);

        ahd.left = createTreeWithHorizontalDistance(left, hd -1, depth + 1);
        ahd.right = createTreeWithHorizontalDistance(right, hd + 1, depth + 1);
        return ahd;
    }

    private static class TreeNodeWithHD {
        private TreeNodeWithHD left;
        private TreeNodeWithHD right;
        private int val;
        private int horizontalDistance;
        private int depth;

        public TreeNodeWithHD(TreeNode node, int hd, int depth) {
            this.val = node.val;
            this.horizontalDistance = hd;
            this.depth = depth;
        }

    }

}
