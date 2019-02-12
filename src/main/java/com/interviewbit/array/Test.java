package com.interviewbit.array;

import java.util.ArrayList;

public class Test {

    public static void main(String ...args) {

        ArrayList<ArrayList<Integer>> A  = new ArrayList<>();
//        A : [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]

        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ArrayList<Integer> l3 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l2.add(5);
        l2.add(6);
        l2.add(7);
        l2.add(8);
        l3.add(9);
        l3.add(10);
        l3.add(11);
        l3.add(12);
        A.add(l1);
        A.add(l2);
        A.add(l3);

        ArrayList<ArrayList<Integer>> B = performOps(A);
        for (int i = 0; i < B.size(); i++) {
            for (int j = 0; j < B.get(i).size(); j++) {
                System.out.print(B.get(i).get(j) + " ");
            }
        }

    }

    static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }

}
