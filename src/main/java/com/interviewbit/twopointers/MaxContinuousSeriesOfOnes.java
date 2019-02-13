package com.interviewbit.twopointers;

import java.util.ArrayList;

/**
 * Created by achaudhary on 2/13/19.
 *
 * You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
 Find the position of zeros which when flipped will produce maximum continuous series of 1s.

 For this problem, return the indices of maximum continuous series of 1s in order.

 Example:

 Input :
 Array = {1 1 0 1 1 0 0 1 1 1 }
 M = 1

 Output :
 [0, 1, 2, 3, 4]

 If there are multiple possible solutions, return the sequence which has the minimum start index.
 */

/*
Hint
Hint : Think in terms of 2 pointers.
Would it help if you maintained the number of 0s in the current range ? When would you range become invalid ?

N : 4
lis : 1 0 1 0
M : 2

pointer i and j
i = j = 0
iterate till i < N:
        if(Number_of_Zeros_in_Current_range > M) :
                increment j and reduce range till Number_of_Zeros_in_current_range < M
        else :
                add element in range and update all variables
 */
public class MaxContinuousSeriesOfOnes {

    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        ArrayList<Integer> indicesList = new ArrayList<>();
        int index = 0, count = 0;
        int left = 0, right = 0;
        int flips = B;

        while(right < A.size()) {
            if(A.get(right) == 1) {
                right++;
            } else if(flips > 0) {
                right++;
                flips--;
            } else if (left < right) {
                flips += 1 - A.get(left);
                left++;
            } else {
                left++;
                right++;
            }
            if(right - left > count) {
                index = left;
                count = right - left;
            }
        }

        for (int i = 0; i < count; i++) {
            indicesList.add(index + i);
        }

        return indicesList;
    }


    public ArrayList<Integer> maxoneV2(ArrayList<Integer> A, int B) {
        int index = 0, count = 0;
        int left = 0, right = 0;
        int flips = B;

        while (right < A.size()) {
            if (A.get(right) == 1) {
                right++;
            } else if (flips > 0) { // A.get(right) == 0
                right++;
                flips--;
            } else if (left < right) { // A.get(right) == 0 && flips == 0
                flips += 1 - A.get(left);
                left++;
            } else { // A.get(right) == 0 && flips == 0 && left == right
                left++; right++;
            }

            if (right - left > count) {
                index = left;
                count = right - left;
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < count; i++)
            result.add(index + i);
        return result;
    }
}
