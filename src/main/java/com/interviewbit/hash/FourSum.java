package com.interviewbit.hash;

import java.util.*;

public class FourSum {

    public static void main(String ...args) {

        FourSum fourSum = new FourSum();
        ArrayList<ArrayList<Integer>> arrayLists = fourSum.fourSum(new ArrayList<>(Arrays.asList(9, -8, -10, -7, 7, -8, 2, -7, 4, 7, 0, -3, -4, -5, -1, -4, 5, 8, 1, 9, -2, 5, 10, -5, -7, -1, -6, 4, 1, -5, 3, 8, -4, -10, -9, -3, 10, 0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7, 6, -4, 2, 0, 10, 1, -2, 5, -2)), 0);
        System.out.println(arrayLists);
        Set<Integer> set = new HashSet<>();
    }

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Set<ArrayList<Integer>> resultSet = new LinkedHashSet<>();
        if(A.size() < 4){
            return result;
        }
        Collections.sort(A);
        int i=0, j=1, k=2, l=A.size()-1;
        for(i = 0; i < A.size() - 3; i++){
            for(j = i+1; j < A.size() -2; j++) {
                k = j+1;
                l = A.size()-1;
                int diff = B - (A.get(i) + A.get(j));
                while(k < l) {
                    if(A.get(k) + A.get(l) > diff) {
                        l--;
                    } else if(A.get(k) + A.get(l) < diff) {
                        k++;
                    } else {
                        ArrayList<Integer> entry = new ArrayList<>(Arrays.asList(A.get(i),A.get(j),A.get(k),A.get(l)));
                        resultSet.add(entry);
                        k++;
                        l--;
                    }
                }
            }
        }
        result.addAll(resultSet);

        return result;
    }
}
