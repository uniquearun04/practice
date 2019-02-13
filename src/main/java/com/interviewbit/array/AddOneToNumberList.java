package com.interviewbit.array;

import java.util.ArrayList;

public class AddOneToNumberList {

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int carry = 1;
        int sum = 0;
        for(int i = A.size() - 1; i >= 0; i--) {
            sum = carry + A.get(i);
            carry = sum / 10;
            sum = sum % 10;
            A.set(i,sum);
            if(carry == 0) {
                break;
            }
        }
        if(carry == 1) {
            A.add(0,carry);
        }
        while(A.get(0) == 0) {
            A.remove(0);
        }
        return A;
    }

    public static void main(String ...args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        AddOneToNumberList addOneToNumberList = new AddOneToNumberList();
        addOneToNumberList.plusOne(arrayList);
//        arrayList.

    }

}
