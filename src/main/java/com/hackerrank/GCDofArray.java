package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GCDofArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String [] arr_A = br.readLine().trim().split(" ");
        int A[] = new int[N];
        for (int i_A = 0; i_A < arr_A.length; i_A++) {
            A[i_A] = Integer.parseInt(arr_A[i_A]);
        }
        int out_ = answer(A);
        System.out.println(out_);
        wr.close();
        br.close();
    }

    static int gcd(int a, int b) {
        if(a == 0 || b == 0) {
            return 0;
        }
        if(a == b) return a;

        if(a > b) return gcd(a-b, b);
        return gcd(a, b-a);
    }

    static int answer(int[] A) {

        int gcd = A[0];

        for (int i = 1; i < A.length; i++) {
            gcd = gcd(gcd,A[i]);
        }

        return gcd;
    }
}
