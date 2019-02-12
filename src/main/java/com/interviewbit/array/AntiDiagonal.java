package com.interviewbit.array;

public class AntiDiagonal {

    public int[][] diagonal(int[][] A) {
        int n = A.length;
        if(n == 0) {
            return new int[0][0];
        }
        int [][] result = new int[2*n -1][];
        for(int k = 0; k < 2 * n - 1; k++) {
            int size = (k < n ? k + 1: (2 * n - 1 - k) );
            result[k] = new int[size];
            for(int t = 0, i = (k <= n-1 ? 0 : k -n + 1), j = (k <= n-1 ? k : n-1); (t <= k) && (i < n) && (j >= 0); t++, i++, j--) {
                result[k][t] = A[i][j];
            }
        }
        return result;
    }

    public static void main(String ...args) {
        int [][] A = {{1,2,3},{4,5,6},{7,8,9}};
        AntiDiagonal antiDiagonal = new AntiDiagonal();

        int result[][] = antiDiagonal.diagonal(A);
        System.out.println(A);
    }
}
