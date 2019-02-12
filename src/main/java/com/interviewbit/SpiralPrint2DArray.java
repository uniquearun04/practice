package com.interviewbit;

import java.util.ArrayList;

public class SpiralPrint2DArray {


    public static void main(String ...args) {

//        int[][] arr = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9},
//        };

        int[][] arr = {
                {1},
                {2},
                {3},
        };

        int [] result = spiralArray(arr);
        System.out.println(result);

    }

    public static int [] spiralArray(int [][] A) {
        int row = A.length;
        int col = A[0].length;

        int [] result = new int [row * col];

        int r = 0;

        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = col -1;
        int len = row * col;

        while(top <= bottom && left <= right) {

            for(int i = left; i <= right && r < len; i++) {
                result[r++] = A[top][i];
            }
            top++;
            for(int i = top; i <= bottom && r < len; i++) {
                result[r++] = A[i][right];
            }
            right--;
            for(int i = right; i >= left && r < len; i--) {
                result[r++] = A[bottom][i];
            }
            bottom--;
            for(int i = bottom; i >= top && r < len; i--) {
                result[r++] = A[i][left];
            }
            left++;

        }

        return result;
    }
}
