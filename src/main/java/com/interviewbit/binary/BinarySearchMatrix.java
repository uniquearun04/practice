package com.interviewbit.binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinarySearchMatrix {


    public static void main(String ...args) {

//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(22, 32, 67));
//        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
//        matrix.add(list);
//
//        BinarySearchMatrix binarySearchMatrix = new BinarySearchMatrix();
//        binarySearchMatrix.searchMatrix(matrix, 93);
        int [] A = {1,2,3,7,8,9,10};
        int binarySearch = Arrays.binarySearch(A, 4);
        int binarySearch1 = Arrays.binarySearch(A, 0);
        int binarySearch2 = Arrays.binarySearch(A, 9);
        System.out.println();

    }


    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {

        int rows = a.size();
        int cols = a.get(0).size();
        int i;
        for(i = 0; i < rows; i++) {
            ArrayList<Integer> list = a.get(i);
            if(b <= list.get(cols-1)) {
                break;
            }
        }
        if(b > a.get(rows-1).get(cols-1)) return -1;
        return Collections.binarySearch(a.get(i),b) > -1 ? 1 : 0;
    }
}
