package com.interviewbit.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by achaudhary on 2/12/19.
 *
 *
 *  Given an array with n objects colored red, white or blue,
 sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note: Using library sort function is not allowed.

 Example :

 Input : [0 1 2 0 1 2]
 Modify array so that it becomes : [0 0 1 1 2 2]
 */
public class SortByColors {

    public static void main(String ...args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 0, 1, 2));

        SortByColors sortByColors = new SortByColors();
        sortByColors.sortColors(list);
        System.out.println(list);
    }
    public void sortColors(ArrayList<Integer> a) {

        int red = 0;
        int white = 0;
        int blue = 0;

        for (int i = 0; i < a.size(); i++) {
            if(a.get(i) == 0) {
                red++;
            } else if(a.get(i) == 1) {
                white++;
            } else {
                blue++;
            }
        }
        for (int i = 0; i < red; i++) {
            a.set(i,0);
        }
        for (int i = red; i < red+white; i++) {
            a.set(i,1);
        }
        for (int i = red+white; i < red+white+blue; i++) {
            a.set(i,2);
        }
    }
}
