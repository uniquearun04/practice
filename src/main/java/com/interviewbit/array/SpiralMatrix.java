package com.interviewbit.array;

public class SpiralMatrix {

    public int[][] generateMatrix(int A) {
        int n = A;
        int [][]B = new int[n][n];
        int left = 0; int right = n -1;
        int top = 0; int bottom = n-1;
        int k = 1; int p =0;
        while(left <= right && top <= bottom) {
            for(p = left; p <= right; p++) {
                B[top][p] = k++;
            }
            top++;
            for(p = top; p <= bottom; p++) {
                B[p][right] = k++;
            }
            right--;
            for(p = right; p >= left; p--) {
                B[bottom][p] = k++;
            }
            bottom--;
            for(p = bottom; p>= top; p--) {
                B[p][left] = k++;
            }
            left++;
        }
        return B;
    }

    public static void main(String ...args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int n = 3;
        int[][] matrix = spiralMatrix.generateMatrix(n);
        int[][] matrix1 = spiralMatrix.generateMatrix(4);
        System.out.println(matrix);
    }
}
