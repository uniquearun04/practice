package com.interviewbit.bit;

import java.util.ArrayList;

public class Div {

    public int divide(int A, int B) {
        if(B == 0) return Integer.MAX_VALUE;
        long quotent = 0;

        long a = (long) A;
        long b = (long) B;

        a = Math.abs(a);
        b = Math.abs(b);

        if(a < 0 && b < 0) {

        }


        return false ? -(int)quotent : (int)quotent;
    }

    public static void main(String ...args) {
        int A = -2147483648;
        int B = -1;

        Div div = new Div();
        int divide = div.divide(A, B);

        System.out.println(divide);
    }
}
