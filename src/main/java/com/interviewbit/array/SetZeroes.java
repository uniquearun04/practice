package com.interviewbit.array;

import java.util.ArrayList;

public class SetZeroes {

    public static void main(String ...args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        a.add(a1);
        a.add(a2);
        a1.add(0);
        a1.add(0);
        a2.add(1);
        a2.add(0);
        SetZeroes setZeroes = new SetZeroes();
        setZeroes.setZeroes(a);

    }

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        if(n == 0) return;
        int [] rows = new int[n];
        int [] cols = new int [a.get(0).size()];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < a.get(i).size(); j++ ) {
                if(a.get(i).get(j) == 0) {
                    rows[i] = -1;
                    cols[j] = -1;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < a.get(i).size(); j++) {
                if(rows[i] == -1 || cols[j] == -1) {
                    a.get(i).set(j,0);
                }
            }
        }
    }
}
