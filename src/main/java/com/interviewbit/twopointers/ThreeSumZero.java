package com.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by achaudhary on 2/12/19.
 */

/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.
 */
public class ThreeSumZero {

    public static void main(String ...args) {

        ArrayList<Integer> inputList = new ArrayList<>(Arrays.asList(1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3 ));

        ThreeSumZero threeSumZero = new ThreeSumZero();
        ArrayList<ArrayList<Integer>> arrayLists = threeSumZero.threeSum(inputList);
        System.out.println(arrayLists);
    }

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {

        Collections.sort(A);
        int n = A.size();

        int target = 0;
        ArrayList<ArrayList<Integer>> outputList = new ArrayList<>();

        for (int i = 0; i < n-2; i++) {
            int j, k;
            j = i + 1;
            k = n-1;
            int sum = 0;
            while(j < k) {
                sum = A.get(i) + A.get(j) + A.get(k);
                if(sum == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(A.get(i));
                    list.add(A.get(j));
                    list.add(A.get(k));
                    addList(outputList, list);
                    k--;
                    j++;
                } else if( sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return outputList;
    }

    private void addList(ArrayList<ArrayList<Integer>> outputList, ArrayList<Integer> list) {
        for(List l : outputList) {
            if(l.containsAll(list) && list.containsAll(l)) {
                return;
            }
        }
        outputList.add(list);
    }
}
