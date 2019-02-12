package com.interviewbit.array;

public class RotateMatrix90D {
    public static void main(String ...args) {
        RotateMatrix90D rotateMatrix90D = new RotateMatrix90D();
        int [][]A = {{1,2,3},{4,5,6},{7,8,9}};
        rotateMatrix90D.rotate(A);
        System.out.println(A);
    }

    public void rotate(int [][] A) {
        int n = A.length - 1;
        for(int i = 0; i < A.length / 2; i++) {
            for(int j = i; j < n - i; j++) {
                int temp1 = A[n-j][i];
                int temp2 = A[n-i][n-j];
                int temp3 = A[j][n-i];
                int temp4 = A[i][j];

                A[i][j] = temp1;
                A[n-j][i] = temp2;
                A[n-i][n-j] = temp3;
                A[j][n-i] = temp4;
            }
        }
    }
}
