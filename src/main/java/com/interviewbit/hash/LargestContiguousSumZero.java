package com.interviewbit.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestContiguousSumZero {

    public static void main(String ...args) {

        LargestContiguousSumZero largestContiguousSumZero = new LargestContiguousSumZero();
//        ArrayList<Integer> lszero = largestContiguousSumZero.lszero(new ArrayList<>(Arrays.asList(1, 2, -2, 4, -4)));
//        ArrayList<Integer> lszero = largestContiguousSumZero.lszero(new ArrayList<>(Arrays.asList(1, 2, -3, 3 )));
//        ArrayList<Integer> lszero = largestContiguousSumZero.lszero(new ArrayList<>(Arrays.asList(-19, 8, 2, -8, 19, 5, -2, -23 )));
        ArrayList<Integer> lszero = largestContiguousSumZero.lszero(new ArrayList<>(Arrays.asList(-8, 8, -1, -16, -28, -27, 15, -14, 14, -27, -5, -6, -25, -11, 28, 29, -3, -25, 17, -25, 4, -20, 2, 1, -17, -10, -25 )));
        System.out.println(lszero);
    }

    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        ArrayList<Integer> sumArray = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            sumArray.add(sum);
        }
        int i = 0;
        for(int j = 0; j < sumArray.size(); j++) {
            sum = sumArray.get(j);
            if(map.containsKey(sum)) {
                i = map.get(sum);
                if(j - i - 1 > max) {
                    max = j- i -1;
                    result.clear();
                    result.add(i);
                    result.add(j);
                }

            } else {
                map.put(sum, j);
            }
        }
        int j = 0;
        if(result.size() > 0) {
            i = result.get(0);
            j = result.get(1);

            if(result.size() >= 2) {
                result.clear();
                for(int k = i+1; k <= j; k++) {
                    result.add(A.get(k));
                }
            }
        }
        int k = 0;
        for (k = sumArray.size()-1; k > 0; k--) {
            if(sumArray.get(k) == 0) {
                break;
            }
        }

        if (i != j && k > (j - i -1)) {
            result.clear();
            for (int l = 0; l <= k; l++) {
                result.add(A.get(l));
            }

        }
        return result;
    }
}
