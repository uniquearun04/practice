package com.interviewbit.array;

import java.util.ArrayList;
import java.util.List;

public class PrintSpiralMatrix {

    public static void main(String ...args) {
        List<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list0 = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list.add(list0);
        list.add(list1);
        list.add(list2);
        list0.add(1);
        list1.add(2);
        list2.add(3);
        PrintSpiralMatrix printSpiralMatrix = new PrintSpiralMatrix();
        ArrayList<Integer> arrayList = printSpiralMatrix.spiralOrder(list);
        System.out.println(arrayList);
    }

    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int row = A.size();
        int col = A.get(0).size();
        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;
        ArrayList<Integer> result = new ArrayList<>();
        while(left <= right && top <= bottom) {
            for(int i = left; i <= right; i++) {
                result.add(A.get(top).get(i));
            }
            top++;
            for(int i = top; i <= bottom; i++) {
                result.add(A.get(i).get(right));
            }
            right--;
            if(right >= 0){
                for(int i = right; i >= left; i--) {
                    result.add(A.get(bottom).get(i));
                }
                bottom--;
            }

            if(bottom >= 0){
                for(int i = bottom; i >= top; i--) {
                    result.add(A.get(i).get(left));
                }
                left++;
            }

        }

        return result;
    }
}
