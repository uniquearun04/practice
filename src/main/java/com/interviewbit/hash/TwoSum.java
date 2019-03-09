package com.interviewbit.hash;

import java.util.*;

/**
 * Created by achaudhary on 3/9/19.
 */
/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based.
Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.

Input: [2, 7, 11, 15], target=9
Output: index1 = 1, index2 = 2
 */
public class TwoSum {

    public static void main(String ...args) {
        TwoSum twoSum = new TwoSum();
        twoSum.twoSum(Arrays.asList(4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8), -3);
    }

    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {

        Map<Integer, List<Integer>> numVsIndexList = new HashMap<>();
        int num;
        for (int i = 0; i < A.size(); i++) {
            num = A.get(i);
            List<Integer> indexList = numVsIndexList.get(num);
            if(indexList == null) {
                indexList = new ArrayList<>();
                numVsIndexList.put(num, indexList);
            }
            indexList.add(i+1);
        }
        ArrayList<Integer> res = new ArrayList<>();

        int diff = 0;

        List<List<Integer>> resultSet = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            num = A.get(i);
            diff = B - num;
            List<Integer> indexList = numVsIndexList.get(diff);
            if(indexList != null && indexList.size() > 0) {
                int j = indexList.get(0);
                if(i + 1 == j && indexList.size() < 2) {
                    continue;
                } else if(i + 1 == j && indexList.size() >= 2) {
                    j = indexList.get(1);
                }
                if(i + 1 < j) {
                    resultSet.add(Arrays.asList(i+1, j));
                }
            }
        }

        int i = Integer.MAX_VALUE, j = Integer.MAX_VALUE;
        for (int k = 0; k < resultSet.size(); k++) {
            List<Integer> list = resultSet.get(k);
            Integer x = list.get(0);
            Integer y = list.get(1);
            if(y < j) {
                j = y;
                i = x;
            } else if(y == j) {
                if(x < i) {
                    j = y;
                    i = x;
                }
            }
        }
        if(resultSet.size() > 0) {
            res.add(i);
            res.add(j);
        }

        return res;
    }
}
