package com.interviewbit;

import java.util.ArrayList;

public class PrettyPrint {

    public static void main(String ...args) {
        PrettyPrint prettyPrint = new PrettyPrint();
        ArrayList<ArrayList<Integer>> arrayLists = prettyPrint.prettyPrint(3);
        System.out.println(arrayLists);
    }

    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        ArrayList<ArrayList<Integer>>rows=new ArrayList<>();
        int mid=A;
        A=A*2-1;

        for(int i=0;i<A;i++){
            ArrayList<Integer>columns=new ArrayList<>();
            for(int j=0;j<A;j++){
                columns.add(Math.max(Math.abs(i-A/2),Math.abs(j-A/2))+1);
            }
            rows.add(columns);
        }
        return rows;
    }
}
