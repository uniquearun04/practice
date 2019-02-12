package com.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by achaudhary on 2/12/19.
 *
 * Remove duplicates from Sorted Array
 Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

 Note that even though we want you to return the new length, make sure to change the original array as well in place

 Do not allocate extra space for another array, you must do this in place with constant memory.
 */
public class RemoveDuplicates {

    public static void main(String ...args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList( 5000, 5000, 5000, 6000, 6000, 7000, 7000, 8000, 9000 ));

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int length = removeDuplicates.removeDuplicatesV2(list);
        System.out.println(length);
    }
    public int removeDuplicates(ArrayList<Integer> a) {

        int i = 0;

        if(a.size() < 2) return a.size();

        while (i < a.size() - 1) {
            if(!a.get(i).equals(a.get(i+1))) {
                i++;
            } else {
                a.remove(i+1);
            }

        }

        return a.size();
    }


    public int removeDuplicatesV2(ArrayList<Integer> a) {
        if (a.size() < 2) return a.size();

        // List#remove is proportional to the number of elements after the removed index
        // Thus, we move from the end for optimal run time
        int prev = a.get(a.size() - 1);
        for (int i = a.size() - 2; i >= 0; i--) {
            if (a.get(i) == prev) {
                a.remove(i);
            }
            else {
                prev = a.get(i);
            }
        }

        return a.size();
    }
}
