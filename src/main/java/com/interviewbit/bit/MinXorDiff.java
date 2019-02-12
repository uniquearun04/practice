package com.interviewbit.bit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinXorDiff {


    public static void main(String ...args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(4);
        list.add(6);
        list.add(10);
        MinXorDiff minXorDiff = new MinXorDiff();
        int minXor = minXorDiff.findMinXor(list);
        System.out.println(minXor);
    }


    public int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int min = Integer.MAX_VALUE;
        int xorDiff = 0;
        for(int i = 0; i < A.size()-1; i++) {
            xorDiff = A.get(i) ^ A.get(i+1);
            if(xorDiff < min) {
                min = xorDiff;
            }
        }

        return min;
    }
}
