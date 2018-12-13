package com.hackerrank.practice; /**
 * Created by achaudhary on 9/19/18.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SwapTreeNodesAtHeightK {

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */

        int n = indexes.length;
        Node[] nodes = new Node[n+1];
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            nodes[indexesRowItr+1].left = indexes[indexesRowItr][0] == -1 ? null : nodes[indexes[indexesRowItr][0]];
            nodes[indexesRowItr+1].right = indexes[indexesRowItr][1] == -1 ? null : nodes[indexes[indexesRowItr][1]];
        }
        int[][] result = new int[queries.length][n];

        for(int i = 0; i < queries.length; i++) {
            swap(nodes[1],queries[i], 1);
            result[i] = getInordeTraversalArray(nodes[1]);
        }
        return result;
    }

    private static int[] getInordeTraversalArray(Node node) {
        List<Integer> inorderTraversalList = new ArrayList<>();
        int [] result;
        inorderTraversal(node, inorderTraversalList);
        result = new int[inorderTraversalList.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = inorderTraversalList.get(i);
        }
        System.out.println(inorderTraversalList);
        return result;
    }

    static void inorderTraversal(Node node, List<Integer> traversalList) {
        if(node != null) {
            inorderTraversal(node.left, traversalList);
            traversalList.add(node.value);
            inorderTraversal(node.right, traversalList);
        }
    }

    static void swap(Node node, int K, int depth) {
        if(node == null) {
            return;
        }
        if(depth % K == 0) {
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        swap(node.left, K, depth +1);
        swap(node.right, K, depth + 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }

}

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return " "+value;
    }
}
