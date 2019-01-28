package com.interviewbit.math;

import java.util.ArrayList;

public class BUG02 {

    public static ArrayList<ArrayList<Integer>> squareSum(int A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        for (int a = 1; a * a < A; a++) {
            System.out.println("a: "+a);
            for (int b = 1; b * b < A; b++) {
                System.out.println("b: "+b);

                if ( a >= b && a * a + b * b == A) {
                    ArrayList<Integer> newEntry = new ArrayList<Integer>();
                    newEntry.add(a);
                    newEntry.add(b);
                    ans.add(newEntry);
                }
            }
        }
        return ans;
    }

    public static void main(String ...args) {

        ArrayList<ArrayList<Integer>> list = squareSum(8);
        System.out.println(list);
    }
}
