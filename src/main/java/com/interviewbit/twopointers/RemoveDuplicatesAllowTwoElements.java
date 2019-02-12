package com.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by achaudhary on 2/12/19.
 *
 Remove Duplicates from Sorted Array

 Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 Note that even though we want you to return the new length, make sure to change the original array as well in place

 For example,
 Given input array A = [1,1,1,2],

 Your function should return length = 3, and A is now [1,1,2].
 */
public class RemoveDuplicatesAllowTwoElements {

    public static void main(String ...args) {
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3));
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1000, 1000, 1000, 1000, 1001, 1002, 1003, 1003, 1004, 1010));
        RemoveDuplicatesAllowTwoElements removeDuplicates = new RemoveDuplicatesAllowTwoElements();
        int length = removeDuplicates.removeDuplicates(list);
        System.out.println(length);
    }
    public int removeDuplicates(ArrayList<Integer> a) {

        int i = 0;

        if(a.size() <= 2) return a.size();

        while (i < a.size() - 2) {
            if(!a.get(i).equals(a.get(i+1))) {
                i++;
            } else if(i < a.size() - 2 && (a.get(i).equals(a.get(i+2)))){
                a.remove(i+2);
            } else {
                i+=2;
            }
        }

        return a.size();
    }


    public int removeDuplicatesV2(ArrayList<Integer> a) {
        int l = a.size();
        if(l == 0 || l==1) return l;
        int k=1, c=0;

        for(int i=1;i<l;i++) {
            if((int)a.get(i) != (int)a.get(i-1)) {
                a.set(k, a.get(i));
                k++;
                c=0;
            }
            else c++;
            if((int)a.get(i) == (int)a.get(i-1) && c == 1) {
                a.set(k,a.get(i));
                k++;
            }
        }
        return k;
    }
}
