package com.poynt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Created by achaudhary on 9/28/18.
 */
public class KDistanceNodesInBST {


    public static void main(String ...args) {
        Node n0 = new Node(50);

        Node n01 = new Node(25);
        Node n02 = new Node(75);
        n0.left = n01;
        n0.right = n02;

        Node n011 = new Node(12);
        Node n012 = new Node(36);
        n01.left = n011;
        n01.right = n012;
        Node n021 = new Node(65);
        Node n022 = new Node(90);
        n02.left = n021;
        n02.right = n022;

        Node n0111 = new Node(6);
        Node n0112 = new Node(15);
        n011.left = n0111;
        n011.right = n0112;
        Node n0121 = new Node(30);
        Node n0122 = new Node(40);
        n012.left = n0121;
        n012.right = n0122;

        Node n0211 = new Node(60);
        Node n0212 = new Node(70);
        n021.left = n0211;
        n021.right = n0212;
        Node n0221 = new Node(80);
        Node n0222 = new Node(95);
        n022.left = n0221;
        n022.right = n0222;

        Node n01111 = new Node(3);
        Node n01112 = new Node(8);
        n0111.left = n01111;
        n0111.right = n01112;
        Node n01121 = new Node(13);
        Node n01122 = new Node(17);
        n0112.left = n01121;
        n0112.right = n01122;
        Node n01211 = new Node(29);
        Node n01212 = new Node(35);
        n0121.left = n01211;
        n0121.right = n01212;
        Node n01221 = new Node(37);
        Node n01222 = new Node(49);
        n0122.left = n01221;
        n0122.right = n01222;
        Node n02111 = new Node(55);
        Node n02112 = new Node(64);
        n0211.left = n02111;
        n0211.right = n02112;
        Node n02121 = new Node(66);
        Node n02122 = new Node(72);
        n0212.left = n02121;
        n0212.right = n02122;
        Node n02211 = new Node(77);
        Node n02212 = new Node(85);
        n0221.left = n02211;
        n0221.right = n02212;
        Node n02221 = new Node(94);
        Node n02222 = new Node(100);
        n0222.left = n02221;
        n0222.right = n02222;

        KDistanceNodesInBST bst = new KDistanceNodesInBST();
        bst.findAndPrint(n0, 12, 2);
        bst.findAndPrint(n0, 6, 2);
        bst.findAndPrint(n0, 6, 3);
        bst.findAndPrint(n0, 30, 4);
        bst.findAndPrint(n0, 33, 4);
        bst.findAndPrint(n0, 50, 0);
        bst.findAndPrint(n0, 3, 4);

    }

    public void findAndPrint(Node root, int targetNodeValue, int distance) {
        System.out.print("targetNodeVal: "+targetNodeValue+"\tdistance: "+distance+"\t-->");
        List<Node> kDistanceNodes = findKDistanceNodes(root, targetNodeValue,distance);
        printList(kDistanceNodes);
    }


    public void printList(List<Node> nodeList) {
        StringJoiner joiner = new StringJoiner(",");
        nodeList.forEach(node -> joiner.add(node.val+""));
        System.out.println(joiner.toString());
    }

    public List<Node> findKDistanceNodes(Node root, int val, int distance) {

        List<Node> nodeList = new ArrayList<>();
        Node targetNode = null;
        targetNode = searchNode(root, val, 0);
        int targetNodeHeight = findTargetNodeHeight(root, val, 0);

        int currentNodeHeight = 0;

        if(Objects.nonNull(targetNode)) {
            Node currentNode = root;
            while(Objects.nonNull(currentNode)) {

                if(distance - currentNodeHeight - targetNodeHeight == 0 && currentNode.val != targetNode.val) {
                    nodeList.add(currentNode);
                }
                if(targetNode.val < currentNode.val) {
                    nodeList.addAll(findKDistanceNodesDown(currentNode.right, distance - currentNodeHeight - targetNodeHeight -1));
                    targetNodeHeight--;
                    currentNode = currentNode.left;
                } else if(targetNode.val > currentNode.val) {
                    nodeList.addAll(findKDistanceNodesDown(currentNode.left, distance - currentNodeHeight - targetNodeHeight -1));
                    targetNodeHeight--;
                    currentNode = currentNode.right;
                } else {
                    nodeList.addAll(findKDistanceNodesDown(currentNode, distance));
                    currentNode = null;
                }
            }
        }

        return nodeList;
    }


    public List<Node> findKDistanceNodesDown(Node currentNode, int distance) {

        List<Node> nodeList = new ArrayList<>();
        if(Objects.nonNull(currentNode)) {
            if(distance == 0) {
                nodeList.add(currentNode);
            }
            nodeList.addAll(findKDistanceNodesDown(currentNode.left, distance - 1));
            nodeList.addAll(findKDistanceNodesDown(currentNode.right, distance - 1));
        }

        return nodeList;
    }

    public Node searchNode(Node root, int val, int height) {
        Node currentNode = root;
        while(Objects.nonNull(currentNode)) {
            if(currentNode.val == val) {
                return currentNode;
            }
            if(val < currentNode.val) {
                return searchNode(currentNode.left, val, height + 1);
            } else {
                return searchNode(currentNode.right, val, height + 1);
            }
        }
        return null;
    }

    public int findTargetNodeHeight(Node root, int val, int height) {
        Node currentNode = root;
        while(Objects.nonNull(currentNode)) {
            if(currentNode.val == val) {
                return height;
            }
            if(val < currentNode.val) {
                return findTargetNodeHeight(currentNode.left, val, height + 1);
            } else {
                return findTargetNodeHeight(currentNode.right, val, height + 1);
            }
        }
        return height;
    }


    private static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public String toString() {
            return ""+val;
        }

    }
}
