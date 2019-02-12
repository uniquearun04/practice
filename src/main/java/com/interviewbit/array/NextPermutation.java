package com.interviewbit.array;

import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation {

    public static void main(String ...args) {

    }

    public void nextPermutation(ArrayList<Integer> a) {

        int n = a.size();
        int index = -1;

        for (int i = n -1; i > 0 ; i--) {
            if(a.get(i) > a.get(i-1)) {
                index = i-1;
                break;
            }
        }
        if(index == -1) {
            Collections.sort(a);
        } else {
            int swapIndex = -1;
            for (int i = n-1; i > index ; i--) {
                if(a.get(i) > a.get(index)) {
                    swapIndex = i;
                    break;
                }
            }
            int tmp = a.get(index);
            a.set(index, a.get(swapIndex));
            a.set(swapIndex, tmp);
            Collections.sort(a.subList(index+1, n));
        }
    }
}
