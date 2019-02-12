package com.interviewbit.array;

public class PascalTraingle {

    public int[][] solve(int A) {
        if(A <= 0) {
            return new int[0][0];
        }
        int [][] B = new int [A][];
        B[0] = new int[1];
        B[0][0] = 1;
        for(int i = 1; i < A; i++) {
            B[i] = new int[i+1];
            for(int j = 0; j < B[i].length; j++) {
                B[i][j] = (j-1 >= 0 ? B[i-1][j-1] : 0) + (j>i-1?0: B[i-1][j]);
            }
        }
        return B;
    }

    public static void main(String ...args) {
        int A = 2;
        PascalTraingle pascalTraingle = new PascalTraingle();
//        int[][] A1 = pascalTraingle.solve(1);
//        int[][] A2 = pascalTraingle.solve(2);
//        int[][] A3 = pascalTraingle.solve(3);
//        int[][] A4 = pascalTraingle.solve(4);
        int[][] A5 = pascalTraingle.solve(5);
        System.out.println(A);
    }
}
