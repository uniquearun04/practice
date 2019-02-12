package com.interviewbit.twopointers;

import java.util.ArrayList;

/**
 * Created by achaudhary on 2/12/19.
 Given an array ‘A’ of sorted integers and another non negative integer k,
 find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 Try doing this in less than linear space complexity.
 */

public class Diffk {

    public int diffPossible(ArrayList<Integer> A, int B) {

        int n = A.size();
        int i = 0;
        int j = i + 1;

        while(i < n && j < n) {
            int diff = A.get(j) - A.get(i);
            if(diff == B && i != j) return 1;
            if(diff < B) {
                j++;
            } else {
                i++;
            }
        }

        return 0;
    }
}
