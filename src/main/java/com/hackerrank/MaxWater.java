package com.hackerrank;

import com.hackerrank.atlassian.CheckSubList;

import java.io.*;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class MaxWater {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());

        for (int t_i = 0; t_i < T; t_i++) {
            int A_size = Integer.parseInt(br.readLine().trim());
            String [] arr_A = br.readLine().trim().split(" ");
            int A[] = new int[A_size];

            for (int i_A = 0; i_A < arr_A.length; i_A++) {
                A[i_A] = Integer.parseInt(arr_A[i_A]);
            }
            long out_ = answer(A, A_size);
            System.out.println(out_);
        }



        wr.close();
        br.close();
    }

    static long answer(int[] A, int N) {
        int n = N + 1;

        int B[][] = new int[n][n];
        long max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n && (i - j) > 1; j++) {
                B[i][j] = (i - j - 1) * Math.min(A[i-1],A[j-1]);
                if(B[i][j] > max) {
                    max = B[i][j];
                }
            }

        }

        return max;
    }

}
