package com.interviewbit.math;

public class TrailingZerosFactN {


    public static void main(String ...args) {
        TrailingZerosFactN trailingZerosFactN = new TrailingZerosFactN();
        System.out.println(trailingZerosFactN.findTrailingZerosInFactN(5));
        System.out.println(trailingZerosFactN.findTrailingZerosInFactN(10));
        System.out.println(trailingZerosFactN.findTrailingZerosInFactN(15));
        System.out.println(trailingZerosFactN.findTrailingZerosInFactN(20));
        System.out.println(trailingZerosFactN.findTrailingZerosInFactN(25));
        System.out.println(trailingZerosFactN.findTrailingZerosInFactN(50));
        System.out.println(trailingZerosFactN.findTrailingZerosInFactN(100));
    }

    public int findTrailingZerosInFactN(int A) {
        int count = 0;

        for(int i = 5; A / i > 0; i*=5) {
            count += A/i;
        }

        return count;
    }
}
